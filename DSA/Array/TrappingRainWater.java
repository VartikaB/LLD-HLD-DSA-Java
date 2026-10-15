package Array;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] h1 = new int[n];
        int[] h2 = new int[n];
        int ans =0;
        h1[0]=height[0];
        h2[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            h1[i]=Math.max(h1[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            h2[i]=Math.max(h2[i+1],height[i]);
        }
        for(int i=0;i<n;i++){
            int h = Math.min(h1[i],h2[i]);
            ans+=h-height[i];
        }
        return ans;
        
    }
}
