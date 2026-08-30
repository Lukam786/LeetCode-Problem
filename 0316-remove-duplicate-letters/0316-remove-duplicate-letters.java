import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {

        int[] lastIndex = new int[26];

        // Store the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            // If already in stack, skip it
            if (visited[curr - 'a']) {
                continue;
            }

            // Remove larger characters if they appear again later
            while (!stack.isEmpty()
                    && stack.peek() > curr
                    && lastIndex[stack.peek() - 'a'] > i) {

                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }

            stack.push(curr);
            visited[curr - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}