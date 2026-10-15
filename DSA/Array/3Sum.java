package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
        1 - sort the array
        2 - loop intot array elements take ith element and for rest do 2 pointer approach 
        3 - once we get a triplet remove redundant 
        4 - if triplet is greater than 0 reduce sum right -- 
        5 - if triplet is less than 0 incerase sum left++
         */
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            
            int a = nums[i];
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;
                
                if (sum == 0) {
                    ans.add(Arrays.asList(a, b, c));
                    left++;
                    right--;
                    
                    // Skip duplicates for 'b'
                    while (left < n && nums[left] == b) left++;
                    // Skip duplicates for 'c'
                    while (right >= 0 && nums[right] == c) right--;
                } 
                else if (sum > 0) {
                    right--;
                } 
                else {
                    left++;
                }
            }
        }
        return ans;
        
    }
}
