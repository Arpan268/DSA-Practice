class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) return false;
            map.put(s.charAt(i), t.charAt(i));
        }

        for(char ch: map.values()) {
            if(set.contains(ch)) return false;
            set.add(ch);
        }

        return true;
    }
}