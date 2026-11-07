class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int num = 0;
        String curr = "";

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // Opening bracket
            else if (ch == '[') {
                numStack.push(num);
                strStack.push(curr);

                num = 0;
                curr = "";
            }

            // Closing bracket
            else if (ch == ']') {
                int repeat = numStack.pop();
                String previous = strStack.pop();

                String temp = "";

                for (int j = 0; j < repeat; j++) {
                    temp += curr;
                }

                curr = previous + temp;
            }

            // Character
            else {
                curr += ch;
            }
        }

        return curr;
    }
}