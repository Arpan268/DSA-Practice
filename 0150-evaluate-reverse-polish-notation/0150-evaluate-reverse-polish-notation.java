class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                n2 += n1;
                stack.push(n2);
            } else if (s.equals("-")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                n2 -= n1;
                stack.push(n2);
            } else if (s.equals("*")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                n2 *= n1;
                stack.push(n2);
            } else if (s.equals("/")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                n2 /= n1;
                stack.push(n2);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}