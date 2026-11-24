
class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int maxAltitudes = 0;

        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            maxAltitudes = Math.max(maxAltitudes, sum);
        }

        return maxAltitudes;
    }
}
