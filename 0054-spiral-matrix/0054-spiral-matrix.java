class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int sr = 0, sc = 0, er = n - 1, ec = m - 1;

        while (sr <= er && sc <= ec) {

            int row = sr;

            // Top side;
            for (int col = sc; col <= ec; col++) {
                ans.add(matrix[row][col]);
            }
            sr++;

            // Right side;
            int col = ec;

            for (int row2 = sr; row2 <= er; row2++) {
                ans.add(matrix[row2][col]);
            }
            ec--;

            // Bottom side;
            row = er;

            if (sr <= er) {
                for (int col2 = ec; col2 >= sc; col2--) {
                    ans.add(matrix[row][col2]);
                }
                er--;
            }

            // Left side;
            col = sc;

            if (sc <= ec) {
                for (int row2 = er; row2 >= sr; row2--) {
                    ans.add(matrix[row2][col]);
                }
                sc++;
            }
        }

        return ans;
    }
}