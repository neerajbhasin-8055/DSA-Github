param([string]$RepoPath = (Get-Location).Path)

Set-Location $RepoPath

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$genScript = Join-Path $scriptDir "generate_readme.ps1"

function Update-ReadmeAndPush {
    & powershell -ExecutionPolicy Bypass -File $genScript -RepoPath $RepoPath
    git add README.md
    $staged = git diff --cached --name-only
    if ($staged -match 'README.md') {
        git commit -m "chore(readme): auto-update README"
        git push
        Write-Host "README updated and pushed." -ForegroundColor Green
    } else {
        Write-Host "No README changes to commit." -ForegroundColor Yellow
    }
}

Write-Host "Starting watcher for Java file changes in: $RepoPath"

$fsw = New-Object System.IO.FileSystemWatcher $RepoPath, "*.java"
$fsw.IncludeSubdirectories = $false
$fsw.EnableRaisingEvents = $true

$debounceTimer = $null

$action = {
    if ($debounceTimer -ne $null) {
        $debounceTimer.Stop()
        $debounceTimer.Dispose()
    }
    $debounceTimer = New-Object Timers.Timer 1500
    $debounceTimer.AutoReset = $false
    $debounceTimer.add_Elapsed({ Update-ReadmeAndPush })
    $debounceTimer.Start()
}

$createdSub = Register-ObjectEvent $fsw Created -Action $action
$changedSub = Register-ObjectEvent $fsw Changed -Action $action
$deletedSub = Register-ObjectEvent $fsw Deleted -Action $action
$renamedSub = Register-ObjectEvent $fsw Renamed -Action $action

Write-Host "Watcher is running. Press Enter to stop." -ForegroundColor Cyan
Read-Host | Out-Null

# cleanup
Unregister-Event -SubscriptionId $createdSub.Id
Unregister-Event -SubscriptionId $changedSub.Id
Unregister-Event -SubscriptionId $deletedSub.Id
Unregister-Event -SubscriptionId $renamedSub.Id
$fsw.Dispose()
Write-Host "Watcher stopped." -ForegroundColor Cyan
