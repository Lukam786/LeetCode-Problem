class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int sign = 1;
        int num = 0;

        // Step 1: spaces remove
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: sign check
        if (i < s.length()) {

            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }
            else if (s.charAt(i) == '+') {
                i++;
            }
        }

        // Step 3: digits read
        while (i < s.length() && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // num = 214748364
            if (num == Integer.MAX_VALUE / 10) {

                if (sign == 1) {

                    // 2147483647 is allowed
                    if (digit >= 7) {
                        return Integer.MAX_VALUE;
                    }
                }
                else {

                    // -2147483648 is allowed
                    if (digit >= 8) {
                        return Integer.MIN_VALUE;
                    }
                }
            }

             if (num > Integer.MAX_VALUE / 10) {

                if (sign == 1) {
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }

            num = num * 10 + digit;

            i++;
        }

        return sign * num;
    }
}