class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[] = s.split(" ");
        if(arr.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i = 0; i<arr.length; i++) {
            if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(arr[i])) return false;
            map.put(pattern.charAt(i), arr[i]);
        }

        for(String str: map.values()) {
            if(set.contains(str)) return false;
            set.add(str);
        }

        return true;
    }
}