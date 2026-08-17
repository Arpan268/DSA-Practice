class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int rank[] = new int[26];

        for(int i = 0; i<order.length(); i++) {
            rank[order.charAt(i)-'a'] = i;
        }

        for(int i = 0; i<words.length-1; i++) {
            String current = words[i];
            String next = words[i+1];

            Boolean isValid = false;
            int minLen = Math.min(current.length(), next.length());
            for (int j = 0; j<minLen; j++) {
                char ch1 = current.charAt(j);
                char ch2 = next.charAt(j);

                if(ch1!=ch2) {
                    if(rank[ch1-'a']>rank[ch2-'a']) return false;
                    else {
                        isValid = true;
                        break;
                    }
                }
            }

            if(!isValid && (current.length()>next.length())) return false;
        }
        return true;
    }
}