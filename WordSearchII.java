/*Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.*/

public class Solution {
    public class TrieNode {
        public String result;
        public TrieNode[] next = new TrieNode[26];
    }
    public List<String> findWords(char[][] board, String[] words) {
        // build trie
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (curr.next[c - 'a'] == null) {
                    TrieNode newNode = new TrieNode();
                    curr.next[c - 'a'] = newNode;
                }
                curr = curr.next[c - 'a'];
            }
            curr.result = word;
        }
        int[][] visited = new int[board.length][board[0].length];
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result, visited);
            }
        } 
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result, int[][] visited) {
        if (visited[i][j] == 1) return;
        char c = board[i][j];
        if (root.next[c - 'a'] == null) return;
        if (root.next[c - 'a'].result != null && !result.contains(root.next[c - 'a'].result)) {
            result.add(root.next[c - 'a'].result);
        }
        visited[i][j] = 1;
        if (i > 0) dfs(board, i - 1, j, root.next[c - 'a'], result, visited);
        if (i < board.length - 1) dfs(board, i + 1, j, root.next[c - 'a'], result, visited);
        if (j > 0) dfs(board, i, j - 1, root.next[c - 'a'], result, visited);
        if (j < board[0].length - 1) dfs(board, i, j + 1, root.next[c - 'a'], result, visited);
        visited[i][j] = 0;
    }
}