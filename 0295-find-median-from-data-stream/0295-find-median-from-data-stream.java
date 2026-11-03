class MedianFinder {

    Queue<Integer> min;
    Queue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (max.isEmpty()) {
            max.add(num);
        }
        else if(num >= max.peek()) {
            min.add(num);
        }
        else {
            max.add(num);
        }
        
        if (min.size() > max.size() + 1) {
            max.add(min.poll());
        } else if (max.size() > min.size() + 1) {
            min.add(max.poll());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) {
            return (double) (min.peek() + max.peek()) / 2;
        } else if (max.size() > min.size()) {
            return (double) max.peek();
        } else {
            return (double) min.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */