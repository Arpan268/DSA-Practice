class Solution {
    public String reverseWords(String s) {
        while(s.charAt(0) == ' ') {
            s = s.substring(1);
        }

        String arr[] = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = arr.length-1; i>=0; i--) {
            if(!arr[i].equals("")) sb.append(arr[i]);
            if(i != 0 && arr[i].length()>0) sb.append(' ');
        }

        return sb.toString();
    }
}