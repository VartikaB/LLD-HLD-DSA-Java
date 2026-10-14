package StriverArray;

class Solution {
    //Dutch national flag algo
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[mid]==1) mid++;
            else if(nums[mid]==0) {
                int t = nums[mid];
                nums[mid]=nums[low];
                nums[low]=t;
                mid++;
                low++;
            }
            else if(nums[mid]==2){
                int t = nums[mid];
                nums[mid]=nums[high];
                nums[high]=t;
                high--;
            }
        }

        
    }
}
