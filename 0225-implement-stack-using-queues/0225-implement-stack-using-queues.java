class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if((queue1.isEmpty() && queue2.isEmpty()) || (!queue1.isEmpty() && queue2.isEmpty())) {
            queue1.add(x);
        }
        else if(queue1.isEmpty() && !queue2.isEmpty()) {
            queue2.add(x);
        }
    }
    
    public int pop() {
        int ans = 0;
        if(queue1.isEmpty()) {
            while(queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            ans = queue2.poll();
        }
        else if(queue2.isEmpty()) {
            while(queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            ans = queue1.poll();
        }

        return ans;
    }
    
    public int top() {
        int ans = 0;
        if(queue1.isEmpty()) {
            while(queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            ans = queue2.poll();
            queue1.add(ans);
        }
        else if(queue2.isEmpty()) {
            while(queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            ans = queue1.poll();
            queue2.add(ans);
        }

        return ans;
    }
    
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */