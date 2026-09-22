class Solution {
    private int left = 0;
    private int right = 1;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                checkPalindrome(s, i, i + 1);
            }
            checkPalindrome(s, i - 1, i + 1);
        }

        return s.substring(left, right);
    }

    private void checkPalindrome(String s, int l, int r) {
        while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (r - l > right - left + 1) {
            left = l + 1;
            right = r;
        }
    }
}