
class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            int smallest = minHeap.remove();

            smallest = smallest + 1;

            minHeap.add(smallest);
        }

        long product = 1;
        int mod = 1000000007;

        while (!minHeap.isEmpty()) {
            int value = minHeap.remove();

            product = (product * value) % mod;
        }

        return (int) product;
    }
}
