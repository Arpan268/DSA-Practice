class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0, c = 0;
        char ch = ' ';

        while(i < strs.length) {
            String s = strs[i];
            if(i == 0) {
                if(c == s.length()) {
                    break;
                }
                ch = s.charAt(c);
            }
            if(c == s.length()) {
                break;
            }
            if(ch != s.charAt(c)) {
                break;
            }
            if(i == strs.length - 1) {
                i = 0;
                c++;
            }
            else {
                i++;
            }
        }

        return strs[0].substring(0, c);
    }
}