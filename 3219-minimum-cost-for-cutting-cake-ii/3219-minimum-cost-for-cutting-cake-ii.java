class Solution {

    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {

        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int h = horizontalCut.length - 1;
        int v = verticalCut.length - 1;

        int hp = 1;
        int vp = 1;

        long cost = 0;

        while (h >= 0 && v >= 0) {

            if (horizontalCut[h] >= verticalCut[v]) {

                cost += (long) horizontalCut[h] * vp;
                hp++;
                h--;

            } else {

                cost += (long) verticalCut[v] * hp;
                vp++;
                v--;
            }
        }

        while (h >= 0) {

            cost += (long) horizontalCut[h] * vp;
            h--;
        }

        while (v >= 0) {

            cost += (long) verticalCut[v] * hp;
            v--;
        }

        return cost;
    }
}