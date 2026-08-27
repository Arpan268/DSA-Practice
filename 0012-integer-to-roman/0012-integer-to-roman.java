class Solution {
    public String intToRoman(int num) {
        int value[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<13; i++) {
            int q = num/value[i];
            while(q>0) {
                sb.append(roman[i]);
                q--;
            }
            num = num%value[i];
        }

        return sb.toString();
    }
}