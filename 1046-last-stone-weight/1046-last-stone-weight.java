
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.remove();
            int second = maxHeap.remove();

            if (first != second) {
                int remaining = first - second;
                maxHeap.add(remaining);
            }
        }

        if (maxHeap.size() == 1) {
            int result = maxHeap.peek();
            return result;
        }

        return 0;
    }
}
