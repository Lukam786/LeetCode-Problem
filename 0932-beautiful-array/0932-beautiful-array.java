class Solution {
    public int[] beautifulArray(int n) {
        
        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        while (ans.size() < n) {

            List<Integer> temp = new ArrayList<>();

            // Odd numbers: 2 * element - 1
            for (int num : ans) {
                int odd = 2 * num - 1;

                if (odd <= n) {
                    temp.add(odd);
                }
            }

            // Even numbers: 2 * element
            for (int num : ans) {
                int even = 2 * num;

                if (even <= n) {
                    temp.add(even);
                }
            }

            ans = temp;
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}