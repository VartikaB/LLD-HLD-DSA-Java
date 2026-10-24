package DSA.Hashing;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int ans=0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums) hs.add(i);
        for(int num : hs){
            int count =0 ;
            if(!hs.contains(num-1)){
                while(hs.contains(num+1)){
                    count++;
                    num++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans+1;
        
    }
}
