# DSA Github

This repository contains Java solutions for common data structures and algorithms problems, organized as individual Java files.

## Problem Solutions

| File | Problem | Approach | Discussion |
| --- | --- | --- | --- |
| `930BinarySubarraysWithSum.java` | Binary Subarrays With Sum | Prefix sum + hashmap | Count subarrays with sum = target by tracking prefix frequency, enabling O(n) time. |
| `Celebrity.java` | Find the Celebrity | Candidate elimination + verification | Determine one possible celebrity in a single pass, then verify row/column conditions in a second pass. |
| `ClockHands.java` | Angle Between Clock Hands | Direct math formula | Convert hours and minutes to angles, then compute the minimum angular distance. |
| `CountGoodNumbers.java` | Count Good Numbers | Fast exponentiation with mod | Compute even/odd position counts separately and combine with modular exponentiation. |
| `DailyTemparatures.java` | Daily Temperatures | Monotonic decreasing stack | Use stack of indices to find the next warmer day for each temperature in one scan. |
| `fruitBaskets.java` | Fruit Into Baskets | Sliding window with hashmap | Maintain a window with at most two fruit types and maximize the window length. |
| `GroupAnagram.java` | Group Anagrams | Canonical signature map | Group strings by sorted characters or frequency signature to collect matching anagrams. |
| `Leetcode1358.java` | Number of Substrings Containing All Three Characters | Sliding window / last-seen positions | Count valid substrings ending at each index using last positions of 'a', 'b', and 'c'. |
| `Leetcode1732.java` | Find the Highest Altitude | Prefix sum tracking | Accumulate gain values and keep the maximum altitude seen so far. |
| `LongestCommonPrefix.java` | Longest Common Prefix | Horizontal scanning | Compare strings character by character and shrink the prefix until all strings match. |
| `LongestPalindromicSubstring.java` | Longest Palindromic Substring | Expand around centers | Expand from each center to find odd/even palindromes and track the longest result. |
| `LongestRepeatingCharaterInASubstring.java` | Longest Repeating Character Replacement | Sliding window with frequency counts | Maintain window size based on the most frequent character to find the longest valid substring. |
| `LongestSubstringWithDistinctCharacters.java` | Longest Substring With Distinct Characters | Sliding window + set/map | Use two pointers to expand and shrink the window while keeping all characters unique. |
| `LongestSubstringWithoutRepeatingCharacters.java` | Longest Substring Without Repeating Characters | Sliding window + last index map | Move the left boundary when duplicates occur and track the maximum window length. |
| `maxConsecutiveOnes.java` | Max Consecutive Ones | Linear scan with counter | Count consecutive 1s and update the maximum run length in a single pass. |
| `maxNumberOfBallons.java` | Maximum Number of Balloons | Frequency count | Count required letters and compute the maximum number of complete "balloon" words. |
| `MinimumWindowSubstring.java` | Minimum Window Substring | Sliding window with required counts | Expand until valid then shrink to find the smallest substring covering all target characters. |
| `MinStack.java` | Min Stack | Auxiliary stack or encoded min values | Track the current minimum alongside stack values to support O(1) getMin. |
| `NiceSubarrays.java` | Count Nice Subarrays | Prefix sum of odd counts | Count subarrays with exactly k odd numbers using prefix frequency accumulation. |
| `ProcessStringWithSpecialOperations.java` | Process String With Special Operations | Stack / simulated result build | Process characters and special operators sequentially to reconstruct the final string. |
| `ReversePolishNotation.java` | Evaluate Reverse Polish Notation | Stack evaluation | Push numbers and apply operators to compute the postfix expression result. |
| `SlidingWindowMaximum.java` | Sliding Window Maximum | Monotonic deque | Maintain a decreasing deque of indices to return each window's maximum efficiently. |
| `SortColorsLeetcode.java` | Sort Colors | Dutch National Flag (three pointers) | One-pass partitioning using low/mid/high pointers to place 0s,1s,2s; O(n) time, O(1) space. |
| `StackUsingArrays.java` | Stack Using Arrays | Array-backed stack implementation | Implement push/pop/top/isEmpty using a fixed-size array and pointer. |
| `StockSpan.java` | Stock Span | Monotonic stack | Use a stack of previous price indices to compute each day's span quickly. |
| `subarrayWithKDifferentIntegers.java` | Subarrays with K Different Integers | Sliding window helper count | Use at-most-K and at-most-(K-1) window counts to derive exactly-K subarrays. |
| `ThreeSum.java` | 3Sum | Sort + two pointers | Fix one value and use two pointers to find unique pairs summing to zero. |
| `TrappingRainWater.java` | Trapping Rain Water | Two-pointer / stack | Calculate trapped water by comparing left/right max heights for each position. |
| `ValidParanthesis.java` | Valid Parentheses | Stack matching | Push opening brackets and verify matching closing brackets for valid nesting. |

## Scripts

- `scripts/generate_readme.ps1` — helps generate or update the README file.
- `scripts/watch_and_push.ps1` — watches file changes and pushes updates.

## Notes

Each `.java` file is intended to solve a specific algorithmic challenge, typically from LeetCode or similar competitive programming platforms.
