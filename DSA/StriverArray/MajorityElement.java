package StriverArray;

// https://leetcode.com/problems/majority-element/description/

class Solution {
    public int majorityElement(int[] nums) {
        // [3,2,3] --> majority element cannot cancel
        int num = 0;
        int count =0;
        for(int i : nums){
            if(count==0){
                num=i;
            }
            if(num==i){
                count++;
            }
            else count--;
        }
        return num;
        
    }
}
