class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sMap[] = new int[26];
        int pMap[] = new int[26];

        for(int i = 0; i<p.length(); i++) {
            pMap[p.charAt(i)-'a']++;
        }

        int left = 0;

        for(int right = 0; right<s.length(); right++) {
            sMap[s.charAt(right)-'a']++;

            if(right-left+1 > p.length()) {
                sMap[s.charAt(left)-'a']--;
                left++;
            }

            if(right-left+1 == p.length() && Arrays.equals(sMap, pMap)) list.add(left);
        }

        return list;
    }
}