package StriverArray;
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1 && nums[0]<0) return nums[0];
        int p1=1;
        int p2=1;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(p1==0) p1=1;
            if(p2==0) p2=1;
            p1=p1*nums[i];
            p2=p2*nums[nums.length-1-i];
            ans = Math.max(ans,Math.max(p1,p2));
        }
        return ans; 
    }
}