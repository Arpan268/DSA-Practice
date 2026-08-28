class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i<words.length; i++) {
            int mapped = 1;
            for(int j = 0; j<words[i].length(); j++) {
                if(map.containsKey(pattern.charAt(j)) && map.get(pattern.charAt(j)) != words[i].charAt(j)) {
                    mapped = 0;
                    break;
                }
                map.put(pattern.charAt(j), words[i].charAt(j));
            }
            if(mapped == 1) {
                for(char ch: map.values()) {
                    if(set.contains(ch)) {
                        mapped = 0;
                        break;
                    }
                    set.add(ch);
                }
            }
            map.clear();
            set.clear();
            if(mapped == 1) list.add(words[i]);
        }

        return list;
    }
}