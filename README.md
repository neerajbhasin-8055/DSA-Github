DSA Practice — Java Solutions

This repository contains small Java implementations of common data-structures and algorithm practice problems. Each file is a focused solution or utility intended for study and interview preparation.

Getting started

- Compile all solutions:

```bash
javac *.java
```

- Run a solution by specifying its class name. Example:

```bash
java LongestSubstringWithoutRepeatingCharacters
```

Files and descriptions


`930BinarySubarraysWithSum.java`
- Problem: Count number of binary subarrays with sum equal to `goal`.
- Approach: Uses the common "at most" trick: number of subarrays with sum == goal = atMost(goal) - atMost(goal-1). `atMost` is implemented with a two-pointer sliding window that keeps a running sum.
- Complexity: Time O(n), Space O(1).

`Celebrity.java`
- Problem: Find the celebrity (person known by everyone else but who knows no one) in a directed adjacency matrix.
- Approach: Two implementations included: a brute-force counting approach (compute in/out counts) and an optimal two-pointer candidate-elimination approach followed by validation.
- Complexity: Brute-force O(n^2), Optimal O(n) time and O(1) space.

`Celebrity.class`
- Compiled `.class` file for `Celebrity.java`. This is a generated artifact and can be removed or added to `.gitignore`.

`fruitBaskets.java`
- Problem: Maximum number of fruits (or longest subarray with at most two distinct types).
- Approach: Sliding-window with a HashMap to track counts of fruit types; maintain window with at most two keys and update maximum length.
- Complexity: Time O(n), Space O(1) (bounded by 2 distinct fruit types).

`GroupAnagram.java`
- Problem: Group anagrams from an array of strings.
- Approach: For each string, compute a 26-length frequency signature converted to a string key and use a HashMap to collect groups.
- Complexity: Time O(N * L) where N = number of strings and L = average string length; Space O(N * L) for stored groups.

`Leetcode1358.java`
- Problem: Count substrings that contain at least one of each character 'a', 'b', and 'c' (LeetCode 1358 variant).
- Approach: Sliding window with a small frequency array of size 3; when the window contains all three characters, add contributions based on the remaining suffix length and shrink from left.
- Complexity: Time O(n), Space O(1).

`LongestRepeatingCharaterInASubstring.java`
- Problem: Character Replacement — longest substring after replacing up to `k` characters to make all characters equal.
- Approach: Sliding-window with a frequency array; track `maxFreq` (most frequent char in window) and expand/contract window so that (window length - maxFreq) <= k.
- Complexity: Time O(n), Space O(26) ~ O(1).

`LongestSubstringWithDistinctCharacters.java`
- Problem: Longest substring with at most `k` distinct characters.
- Approach: Sliding-window with a HashMap counting characters; when distinct count exceeds `k`, move left pointer and decrement counts.
- Complexity: Time O(n), Space O(k).

`LongestSubstringWithoutRepeatingCharacters.java`
- Problem: Longest substring without repeating characters.
- Approach: Two-pointer sliding-window with a HashSet to maintain current unique-window; move left pointer to remove duplicates when needed.
- Complexity: Time O(n), Space O(min(n, alphabet)).

`maxConsecutiveOnes.java`
- Problem: Longest run of 1s after flipping at most `k` zeros (variant of max consecutive ones).
- Approach: Sliding-window counting zeros in current window and shrinking when zero-count exceeds `k`.
- Complexity: Time O(n), Space O(1).

`NiceSubarrays.java`
- Problem: Count of subarrays with exactly `k` odd numbers ("nice" subarrays).
- Approach: Prefix-count technique: maintain a map from odd-count → frequency of occurrences; for each index, add frequency of (oddCount - k).
- Complexity: Time O(n), Space O(n) (for prefix frequency map).

`StackUsingArrays.java`
- Problem: Demonstrate stack operations using an underlying array.
- Approach: Basic array-backed stack with `push`, `pop`, `peek`, and `isEmpty` methods and an index `top`.
- Complexity: Operations O(1) time, Space O(size).

`StockSpan.java`
- Problem: Stock Span — for each price, return the number of consecutive days before it with price less than or equal.
- Approach: Maintain a stack of pairs `[price, span]`. For each new price, pop cheaper/equal prices and accumulate their spans, then push the current pair.
- Complexity: Amortized O(1) per `next` call (overall O(n)), Space O(n).

`subarrayWithKDifferentIntegers.java`
- Problem: Count subarrays with exactly `k` distinct integers.
- Approach: Uses the atMost trick: exactlyK = atMost(k) - atMost(k-1). `atMost` is computed with a sliding-window and a frequency HashMap.
- Complexity: Time O(n), Space O(k).

`scripts/generate_readme.ps1` and `scripts/watch_and_push.ps1`
- Helper PowerShell scripts included for convenience: one to regenerate README and another to watch for changes and push commits.


Contributing

- Add solutions as individual `.java` files with a clear filename and a short comment header describing the problem and complexity.
- Prefer keeping each file focused on a single problem; include sample input/output in comments when helpful.

Notes

- Compiled `.class` files may be present; consider adding a `.gitignore` to exclude them (`*.class`).
- If you want, I can expand any file's description with a short summary of the algorithm, complexity, and example — tell me which ones.
