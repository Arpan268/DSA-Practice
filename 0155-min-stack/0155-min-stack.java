class MinStack {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    int top, min;

    public MinStack() {
        map = new HashMap<>();
        list = new ArrayList<>();
        top = -1;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        if(top == -1) {
            min = Integer.MAX_VALUE;
        }
        list.add(++top, value);
        min = Math.min(min, value);
        map.put(top, min);
    }
    
    public void pop() {
        map.remove(top);
        list.remove(top--);
        if(top != -1) {
            min = map.get(top);
        }
    }
    
    public int top() {
        return list.get(top);
    }
    
    public int getMin() {
        return map.get(top);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */