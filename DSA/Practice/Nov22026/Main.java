package DSA.Practice.Nov22026;

/*
Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.

Example 1:
Input: nums = [10, 5, 2, 7, 1, 9],  k=15

Output: 4

// sliding window approach


 */

import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                ans = Math.max(ans, i + 1);
            }

            if (mp.containsKey(sum - k)) {
                ans = Math.max(ans, i - mp.get(sum - k));
            }

            mp.putIfAbsent(sum, i);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.longestSubarray(nums, k);

        System.out.println("Longest Subarray Length: " + result);

        sc.close();
    }
}
