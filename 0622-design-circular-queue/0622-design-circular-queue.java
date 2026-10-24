class MyCircularQueue {

    int arr[];
    int f, r;

    public MyCircularQueue(int k) {
        arr = new int[k];
        f = -1;
        r = -1;
    }
    
    public boolean enQueue(int value) {
        if(f == (r + 1) % arr.length) {
            return false;
        }
        else if(f == -1 && r == -1) {
            f++;
            r++;
            arr[r] = value;
        }
        else {
            r = (r + 1) % arr.length;
            arr[r] = value;
        }

        return true;
    }
    
    public boolean deQueue() {
        if(f == -1 && r == -1) {
            return false;
        }
        else if(f == r) {
            f = -1;
            r = -1;
        }
        else {
            f = (f + 1) % arr.length;
        }

        return true;
    }
    
    public int Front() {
        if(f == -1 && r == -1) {
            return -1;
        }
        return arr[f];
    }
    
    public int Rear() {
        if(f == -1 && r == -1) {
            return -1;
        }
        return arr[r];
    }
    
    public boolean isEmpty() {
        if(f == -1 && r == -1) {
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(f == (r + 1) % arr.length || r == arr.length - 1) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */