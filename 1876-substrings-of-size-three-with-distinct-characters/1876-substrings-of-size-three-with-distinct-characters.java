class Solution {
    public int countGoodSubstrings(String s) {
        int freq[] = new int[26];

        int left = 0, ans = 0;
        for(int right = 0; right<s.length(); right++) {
            freq[s.charAt(right) - 'a']++;

            if(right-left+1 == 3) {
                int count = 0;

                for(int i = 0; i<freq.length; i++) {
                    if(freq[i] > 0) count++;
                }

                if(count == 3) ans++;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }
}