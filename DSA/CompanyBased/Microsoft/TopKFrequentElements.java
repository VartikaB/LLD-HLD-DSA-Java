package DSA.CompanyBased.Microsoft;

import java.util.HashMap;
import java.util.PriorityQueue;

// Method 1: Using HashMap and PriorityQueue

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Using a map to store frequency then using a max heap to find top k frequent elemets
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i: nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
            pq.offer(new int[]{mp.get(i),i});
            if(pq.size()>k) pq.poll();
        }
        int[] ans = new int[k];
        int count=0;
        while(!pq.isEmpty()){
            ans[count++]=pq.poll()[1];
        }
        return ans;

        
    }
}

//Method 2: Using HashMap and Bucket Sort
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Group numbers by frequency
        HashMap<Integer, List<Integer>> buckets = new HashMap<>();

        for (int num : freq.keySet()) {
            int f = freq.get(num);

            buckets.putIfAbsent(f, new ArrayList<>());
            buckets.get(f).add(num);
        }

        // Step 3: Collect k most frequent numbers
        int[] ans = new int[k];
        int index = 0;

        for (int f = nums.length; f >= 1 && index < k; f--) {
            if (buckets.containsKey(f)) {
                for (int num : buckets.get(f)) {
                    ans[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
