class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == ')') {
                count++;
            }
            else if(ch == '(') {
                count--;
            }

            if(count < 0) {
                count = 0;
                continue;
            }
            sb.append(ch);
        }

        String str = sb.reverse().toString();
        sb.setLength(0);
        count = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                count++;
            }
            else if(ch == ')') {
                count--;
            }

            if(count < 0) {
                count = 0;
                continue;
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}