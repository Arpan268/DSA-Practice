class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1map[] = new int[26];
        int s2map[] = new int[26];

        for(int i = 0; i<s1.length(); i++) {
            s1map[s1.charAt(i)-'a']++;
        }

        int left = 0;

        for(int right = 0; right<s2.length(); right++) {
            s2map[s2.charAt(right)-'a']++;

            if(right-left+1 > s1.length()) {
                s2map[s2.charAt(left)-'a']--;
                left++;
            }

            if(right-left+1 == s1.length() && Arrays.equals(s1map, s2map)) {
                return true;
            }
        }

        return false;
    }
}