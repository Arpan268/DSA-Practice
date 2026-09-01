class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        int l = s1.length();

        for(int i = 0; i<l; i++) {
            freq[s1.charAt(i)-'a']++;
        }

        for(int i = 0; i<=s2.length()-l; i++) {
            int tempfreq[] = freq.clone();
            int subarray = l;
            int ans = 0;
            int j = i;
            while(subarray > 0) {
                if(tempfreq[s2.charAt(j)-'a'] > 0) {
                    ans++;
                    tempfreq[s2.charAt(j)-'a']--;
                }
                j++;
                subarray--;
            }
            if(ans == l) return true;
        }

        return false;
    }
}