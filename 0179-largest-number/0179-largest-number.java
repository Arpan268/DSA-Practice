class Solution {
    public String largestNumber(int[] nums) {
        String str[] = new String[nums.length];

        for(int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;

            return order2.compareTo(order1);
            //order1.compareTo(order2) sorts in ascending order but we need descending order so we use order2.compareTo(order1)
        });

        if(str[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s: str) {
            sb.append(s);
        }

        return sb.toString();
    }
}