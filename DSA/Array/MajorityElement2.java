package Array;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 =0;
        int count2 =0;
        int ele1 =0;
        int ele2=0;
        for(int i : nums){
            if(count1==0 && i!=ele2){
                ele1=i;
                count1=1;
            }
            else if(count2==0 && i!=ele1){
                ele2=i;
                count2=1;
            }
            else if(i==ele1) count1++;
            else if(i==ele2) count2++;
            else{
                count1--;
                count2--;
            }

        }
        List<Integer> ans = new ArrayList<>();
        int ans1=0;
        int ans2=0;
        for(int i:nums){
            if(i==ele1) ans1++;
            if(i==ele2) ans2++;
        }
        if(ans1>nums.length/3) ans.add(ele1);
        if(ans2>nums.length/3) ans.add(ele2);
        if(ans.size()==2 && ans.get(0)==ans.get(1)) ans.remove(0);
        return ans;
        
        
    }
}
