class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(!stack1.isEmpty() && s.charAt(i) == '#') {
                stack1.pop();
            }
            else if(s.charAt(i) != '#') {
                stack1.push(s.charAt(i));
            }
        }
        for(int i = 0; i < t.length(); i++) {
            if(!stack2.isEmpty() && t.charAt(i) == '#') {
                stack2.pop();
            }
            else if(t.charAt(i) != '#') {
                stack2.push(t.charAt(i));
            }
        }

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.pop() != stack2.pop()) {
                return false;
            }
        }

        if(!stack1.isEmpty() || !stack2.isEmpty()) {
            return false;
        }

        return true;
    }
}