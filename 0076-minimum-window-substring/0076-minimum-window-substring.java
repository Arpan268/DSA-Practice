class Solution {
    public String minWindow(String s, String t) {
        String str = "";
        int unique = 0, create = 0, minlen = Integer.MAX_VALUE, start = 0;
        Map<Character, Integer> mapt = new HashMap<>();
        Map<Character, Integer> maps = new HashMap<>();

        for(int i = 0; i<t.length(); i++) {
            mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0) + 1);
        }

        unique = mapt.size();

        int left = 0;
        for(int right = 0; right<s.length(); right++) {
            char rightch = s.charAt(right);

            if(mapt.containsKey(rightch)) {
                maps.put(rightch, maps.getOrDefault(rightch, 0) + 1);

                if(maps.get(rightch).equals(mapt.get(rightch))) create++;
            }

            while(create == unique) {
                int currentlen = right - left + 1;
                if(currentlen < minlen) {
                    minlen = currentlen;
                    start = left;
                }
                char ch = s.charAt(left);
                if(mapt.containsKey(ch)) {
                    maps.put(ch, maps.get(ch) - 1);
                    if(maps.get(ch) < mapt.get(ch)) create--;
                }
                left++;
            }
        }

        if(minlen == Integer.MAX_VALUE) return "";
        
        str = s.substring(start, start + minlen);
        return str;
    }
}