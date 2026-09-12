class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            if (map.size() < 3)
                ans = Math.max(ans, right - left + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            }
        }

        return ans;
    }
}