
import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int ans = 0;

        map.put(0, -1);

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (map.containsKey(sum)) {
                ans = Math.max(ans, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }

        return ans;
    }
}
