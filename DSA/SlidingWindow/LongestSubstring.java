package DSA.SlidingWindow;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left=0;
        int right =0;
        int ans=0;
        while(right<s.length()){
            while(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
            }
            ans=Math.max(ans,right-left+1);
            hs.add(s.charAt(right));
            right++;
        }
        return ans;
        
    }
}
