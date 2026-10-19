class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
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
            sb1.append(ch);
        }

        String str = sb1.reverse().toString();
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
            sb2.append(ch);
        }

        return sb2.toString();
    }
}