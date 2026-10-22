class Solution {
    public int longestValidParentheses(String s) {
        int count = 0, length = 0, start = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                count++;
            }
            else {
                count--;
            }

            if(count == 0 && i == s.length() - 1) {
                length = Math.max(length, i - start + 1);
            }

            if(count == 0) {
                length = Math.max(i - start + 1, length);
            }
            else if(count < 0) {
                length = Math.max(i - start, length);
                start = i + 1;
                count = 0;
            }
        }

        count = 0;
        start = s.length() - 1;

        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == ')') {
                count++;
            }
            else {
                count--;
            }

            if(count == 0 && i == 0) {
                length = Math.max(length, start - i + 1);
            }

            if(count == 0) {
                length = Math.max(start - i + 1, length);
            }
            else if(count < 0) {
                length = Math.max(start - i, length);
                start = i - 1;
                count = 0;
            }
        }

        return length;
    }
}