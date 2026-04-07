class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Phase 1: Loop through nums and add to hashmap<key: nums[i], val: occurance(nums[i])>
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // Phase 2: Priority queue with k elements
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Phase 3: Return priority queue as int[k]
        int out[] = new int[k];
        for (int i = 0; i < k; i++) {
            out[i] = pq.poll();
        }
        return out;
    }
}
