class Solution {
    public int findMaximizedCapital(int k, int w,
                                    int[] profits, int[] capital) {

        PriorityQueue<int[]> minCapital =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> maxProfit =
            new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < profits.length; i++) {
            minCapital.add(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {

            while (!minCapital.isEmpty() &&
                   minCapital.peek()[0] <= w) {

                int[] project = minCapital.remove();
                maxProfit.add(project[1]);
            }

            if (maxProfit.isEmpty()) {
                break;
            }

            w += maxProfit.remove();
        }

        return w;
    }
}