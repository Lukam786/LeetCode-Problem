class Solution {

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {

        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int h = horizontalCut.length - 1;
        int v = verticalCut.length - 1;

        int hp = 1;
        int vp = 1;

        int cost = 0;

        while (h >= 0 && v >= 0) {

            if (horizontalCut[h] >= verticalCut[v]) {

                cost += horizontalCut[h] * vp;
                hp++;
                h--;

            } else {

                cost += verticalCut[v] * hp;
                vp++;
                v--;
            }
        }

        while (h >= 0) {

            cost += horizontalCut[h] * vp;
            h--;
        }

        while (v >= 0) {

            cost += verticalCut[v] * hp;
            v--;
        }

        return cost;
    }
}