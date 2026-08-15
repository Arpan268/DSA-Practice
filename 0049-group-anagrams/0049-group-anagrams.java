class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();

        Map<String, List> ansMap = new HashMap<>();
        int countLetter[] = new int[26];

        for(String s: strs) {
            Arrays.fill(countLetter, 0);
            for(int i = 0; i<s.length(); i++) {
                countLetter[s.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int n: countLetter) {
                sb.append("#");
                sb.append(n);
            }
            String key = sb.toString();
            if(!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList());
            }
            ansMap.get(key).add(s);
        }
        return new ArrayList(ansMap.values());
    }
}