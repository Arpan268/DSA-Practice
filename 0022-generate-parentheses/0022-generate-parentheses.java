class Solution {
    public List<String> generateParenthesis(int n) {
        int open = 0, closed = 0;
        String str = "";
        List<String> list = new ArrayList<>();
        backtrack(list, open, closed, str, n);

        return list;
    }

    public void backtrack(List<String> list, int open, int closed, String str, int n) {
        if(open > n || closed > open) {
            return;
        }
        else if(open == n && open == closed) {
            list.add(str);
        }

        if(open < n) {
            backtrack(list, open + 1, closed, str + "(", n);
        }
        if(open > closed) {
            backtrack(list, open, closed + 1, str + ")", n);
        }
    }
}