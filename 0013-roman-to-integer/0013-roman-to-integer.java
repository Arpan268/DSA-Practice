class Solution {
    public int romanToInt(String s) {
        char roman[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int num[] = {1, 5, 10, 50, 100, 500, 1000};
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i<roman.length; i++) {
            map.put(roman[i], num[i]);
        }

        for(int i = 0; i<s.length()-1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i+1);

            if(map.get(current)<map.get(next)) {
                ans = ans - map.get(current);
            }
            else {
                ans = ans + map.get(current);
            }
        }

        ans = ans + map.get(s.charAt(s.length()-1));

        return ans;
    }
}