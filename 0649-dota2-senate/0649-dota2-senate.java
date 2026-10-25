class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new ArrayDeque<>();
        int count = 0;
        char start = ' ';

        for(int i = 0; i < senate.length(); i++) {
            q.add(senate.charAt(i));
        }

        while(count != q.size()) {
            if(count == 0) {
                start = q.peek();
            }
            if(q.peek() == start) {
                count++;
                q.add(q.poll());
            }
            else {
                count--;
                q.poll();
            }
        }

        if(q.peek() == 'R') {
            return "Radiant";
        }
        else {
            return "Dire";
        }
    }
}