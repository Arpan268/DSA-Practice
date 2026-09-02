class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];

        int left = 0, ans = 0, max = 0;

        for(int right = 0; right<s.length(); right++) {
            int index = s.charAt(right)-'A';
            freq[index]++;
            int l = right-left+1;

            max = Math.max(max, freq[index]);

            if(l-max <= k && l > ans) {
                ans = l;
            }
            else {
                freq[s.charAt(left)-'A']--;
                left++;
            }
        }

        return ans;
    }
}