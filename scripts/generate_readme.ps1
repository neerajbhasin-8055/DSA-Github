param([string]$RepoPath = (Get-Location).Path)

Set-Location $RepoPath

$javaFiles = Get-ChildItem -Path $RepoPath -Filter *.java -File | Sort-Object Name

$out = @()
$out += "# DSA Practice"
$out += ""
$out += "This repository contains small Java implementations of common data-structures and algorithm practice problems. Each file implements a focused solution or utility, useful for study and quick testing."
$out += ""
$out += "Files"

foreach ($f in $javaFiles) {
    $content = Get-Content $f.FullName -Raw
    $name = $f.Name
    $hasMain = $content -match "static\s+void\s+main"
    $methodMatches = [regex]::Matches($content, 'public\s+(?:static\s+)?\S+\s+(\w+)\s*\(')
    $methods = ($methodMatches | ForEach-Object { $_.Groups[1].Value }) -join ', '
    if ([string]::IsNullOrWhiteSpace($methods)) { $methods = "(no public methods detected)" }
    $desc = "- **$name**: $methods"
    if ($hasMain) { $desc += " — includes example main" }
    $out += $desc
}

$out += ""
$out += "Quick start"
$out += "- Compile all Java files:"
$out += "```bash"
$out += "javac *.java"
$out += "```"
$out += ""
$out += "- Run the example in Celebrity (if you want to run a file with a main):"
$out += "```bash"
$out += "java Celebrity"
$out += "```"
$out += ""
$out += "Automatic README updates"
$out += "- This repository includes a watcher script that can regenerate README.md when Java files change. See `scripts/watch_and_push.ps1`."
$out += ""
$out += "Notes"
$out += "- Most files expose methods rather than full runnable programs; to test a particular algorithm, either run the provided `main` (if present) or write a small driver that constructs inputs and calls the method."
$out += "- Ensure your Git credentials are configured if you want the watcher to push changes automatically."
$out += ""
$out += "Next steps"
$out += "- Add JUnit tests or simple `main` drivers for classes that lack them to allow quick verification."
$out += "- Optionally add problem statements and complexity notes for each file."

$out | Out-File -FilePath (Join-Path $RepoPath "README.md") -Encoding UTF8

Write-Host "README.md regenerated with $($javaFiles.Count) Java files." -ForegroundColor Green
