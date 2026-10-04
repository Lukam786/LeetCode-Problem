class Solution {
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs,
            (a, b) -> {
                int c1 = a[1] - a[0];
                // cost saving after sending a to bangalore

                int c2 = b[1] - b[0];
                // cost saving after sending b to bangalore

                if (c1 > c2) return -1;
                else if (c2 > c1) return 1;
                else return 0;
            }
        );

        int cost = 0;
        int n = costs.length;

        for (int i = 0; i < n / 2; i++) {
            cost += costs[i][0];
        }

        for (int i = n / 2; i < n; i++) {
            cost += costs[i][1];
        }

        return cost;
    }
}