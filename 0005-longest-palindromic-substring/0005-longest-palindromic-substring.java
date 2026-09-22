class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 1;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                int l = i, r = i + 1;
                while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                if (r - l > right - left + 1) {
                    left = l + 1;
                    right = r;
                }
            }
            int l = i - 1, r = i + 1;
            while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l > right - left + 1) {
                left = l + 1;
                right = r;
            }
        }

        return s.substring(left, right);
    }
}