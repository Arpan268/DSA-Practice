class Solution {

    private class TrieNode {
        TrieNode children[] = new TrieNode[52];
        boolean isEnd = false;
    }

    private boolean dfs(char board[][], int i, int j, TrieNode current) {
        if (board[i][j] == '#') {
            return false;
        }
        char ch = board[i][j];
        int index = -1;

        if (ch >= 'A' && ch <= 'Z') {
            index = ch - 'A' + 26;
        } else {
            index = ch - 'a';
        }

        if (current.children[index] == null) {
            return false;
        }

        TrieNode letter = current.children[index];
        if (letter.isEnd) {
            return true;
        }

        board[i][j] = '#';

        boolean l = false, r = false, u = false, d = false;

        if (i > 0) {
            u = dfs(board, i - 1, j, current.children[index]);
        }
        if (i < board.length - 1) {
            d = dfs(board, i + 1, j, current.children[index]);
        }
        if (j > 0) {
            l = dfs(board, i, j - 1, current.children[index]);
        }
        if (j < board[0].length - 1) {
            r = dfs(board, i, j + 1, current.children[index]);
        }

        board[i][j] = ch;

        return u || d || l || r;
    }

    public boolean exist(char[][] board, String word) {
        TrieNode root = new TrieNode();
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = -1;
            char ch = word.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                index = ch - 'A' + 26;
            } else {
                index = ch - 'a';
            }
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
        current = root;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int index = -1;
                char ch = board[i][j];
                if (ch >= 'A' && ch <= 'Z') {
                    index = ch - 'A' + 26;
                } else {
                    index = ch - 'a';
                }
                if (current.children[index] != null) {
                    if (dfs(board, i, j, current)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}