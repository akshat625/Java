package Trie;

public class CountDistinctRows {
    private static class TrieNode {
        int count; // Number of rows reaching this node
        TrieNode[] children = new TrieNode[2]; // 0 and 1 children
    }

    public static int countDistinctRows(int[][] matrix) {
        TrieNode root = new TrieNode();
        int count = 0;
        for (int[] row : matrix) {
            TrieNode current = root;
            for (int value : row) {
                int index = value; // Assuming only 0 and 1 values
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                } else if (current.count == 1) { // Only increment count if not already counted
                    count++;
                }
                current = current.children[index];
                current.count++; // Increment count for this path
            }
            if (current.count == 1) { // Count the last row if it's unique
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] binaryMatrix = {
                {1, 1, 1},
                {0, 1, 0},
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 0}
        };


        int distinctRows = countDistinctRows(binaryMatrix);
        System.out.println("Number of distinct rows: " + distinctRows);
    }
}

