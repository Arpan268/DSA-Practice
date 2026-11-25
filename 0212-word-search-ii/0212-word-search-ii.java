class Solution {

    private class TrieNode {
        TrieNode children[] = new TrieNode[26];
        boolean isEnd = false;
        boolean isFound = false;
    }

    TrieNode root = new TrieNode();
    List<String> list = new ArrayList<>();

    private void insert(String word) {
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    private void dfs(char[][] board, int i, int j, TrieNode current, String s) {
        if(board[i][j] == '#') {
            return;
        }
        char temp = board[i][j];
        int index = board[i][j] - 'a';

        if(current.children[index] == null) {
            return;
        }
        s += board[i][j];

        if(current.children[index] != null) {
            TrieNode letter = current.children[index];
            if(letter.isEnd && !letter.isFound) {
                list.add(s);
                letter.isFound = true;
            }
        }

        board[i][j] = '#';

        if(i > 0) {
            dfs(board, i - 1, j, current.children[index], s);
        }
        if(i < board.length - 1) {
            dfs(board, i + 1, j, current.children[index], s);
        }
        if(j > 0) {
            dfs(board, i, j - 1, current.children[index], s);
        }
        if(j < board[0].length - 1) {
            dfs(board, i, j + 1, current.children[index], s);
        }
        board[i][j] = temp;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for(String s: words) {
            insert(s);
        }

        TrieNode current = root;
        String s = "";

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int index = board[i][j] - 'a';
                if(current.children[index] != null) {
                    dfs(board, i, j, current, s);
                }
            }
        }

        return list;
    }
}