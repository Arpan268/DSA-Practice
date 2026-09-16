class Solution {
    public boolean isPalindrome(String s) {
        int r = s.length() - 1;

        for (int l = 0; l < r; l++) {
            char cleft = s.charAt(l);
            if (!Character.isLetterOrDigit(cleft))
                continue;

            while (!Character.isLetterOrDigit(s.charAt(r)))
                r--;
            
            char cright = s.charAt(r);
            if (Character.toLowerCase(cleft) != Character.toLowerCase(cright))
                return false;

            r--;
        }

        return true;
    }
}