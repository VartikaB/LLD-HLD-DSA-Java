package Array;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int num1 = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (j>i+1 && nums[j] == nums[j - 1])
                    continue;
                int num2 = nums[j];
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int num3 = nums[left];
                    int num4 = nums[right];
                    long sum = (long) num1 + num2 + num3 + num4;
                    if ( sum == target) {
                        ans.add(new ArrayList<>(Arrays.asList(num1, num2, num3,num4)));
                        while (left < n && num3 == nums[left])
                            left++;
                        while (right >= 0 && num4 == nums[right])
                            right--;
                    }
                    else if(sum  > target) right--;
                    else left++;

                }
            }
        }
        return ans;

    }
}