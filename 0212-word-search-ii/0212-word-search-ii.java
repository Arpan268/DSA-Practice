class Solution {

    private class TrieNode {
        TrieNode children[] = new TrieNode[26];
        boolean isEnd = false;
        boolean isFound = false;
        String word;
        int childCount = 0;
    }

    TrieNode root = new TrieNode();
    List<String> list = new ArrayList<>();

    private void insert(String word) {
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
                current.childCount++;
            }
            current = current.children[index];
        }
        current.word = word;
        current.isEnd = true;
    }

    private void dfs(char[][] board, int i, int j, TrieNode current) {
        if(board[i][j] == '#') {
            return;
        }
        char temp = board[i][j];
        int index = board[i][j] - 'a';

        if(current.children[index] == null) {
            return;
        }


        TrieNode letter = current.children[index];
        if(letter.isEnd && !letter.isFound) {
            list.add(letter.word);
            letter.isFound = true;
        }


        board[i][j] = '#';

        if(i > 0) {
            dfs(board, i - 1, j, current.children[index]);
        }
        if(i < board.length - 1) {
            dfs(board, i + 1, j, current.children[index]);
        }
        if(j > 0) {
            dfs(board, i, j - 1, current.children[index]);
        }
        if(j < board[0].length - 1) {
            dfs(board, i, j + 1, current.children[index]);
        }
        board[i][j] = temp;
        if(letter.childCount == 0 && letter.word == null) {
            current.children[index] = null;
            current.childCount--;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        for(String s: words) {
            insert(s);
        }

        TrieNode current = root;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int index = board[i][j] - 'a';
                if(current.children[index] != null) {
                    dfs(board, i, j, current);
                }
            }
        }

        return list;
    }
}