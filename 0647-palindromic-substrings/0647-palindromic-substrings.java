class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                int l = i - 1, r = i + 2;
                count++;
                while(l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    count++;
                    l--;
                    r++;
                }
            }
            int l = i - 1, r = i + 1;
            count++;
            while(l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }

        return count;
    }
}