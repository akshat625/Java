package Trie;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}
public class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public boolean search(String key){
        TrieNode curr=root;
        for(int i=0;i<key.length();i++){
            int index = key.charAt(i) - 'a';

            if(curr.children[index]==null)
                return false;
            curr = curr.children[index];
        }
        return curr.isEnd;
    }

    public void insert(String key){
        TrieNode curr = root;
        for(int i=0;i<key.length();i++){
            int index = key.charAt(i) - 'a';
            if(curr.children[index]==null)
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.isEnd=true;
    }
    public boolean delete(String key) {
        if (deleteRecursive(root, key, 0)) {
            return true;
        }
        return false;
    }

    private boolean deleteRecursive(TrieNode node, String key, int index) {
        if (node == null) {
            return false;
        }

        if (index == key.length()) {
            node.isEnd = false;
            return true;
        }

        int charIndex = key.charAt(index) - 'a';
        boolean deleted = deleteRecursive(node.children[charIndex], key, index + 1);

        // If the deleted node has no children and isn't the end of a key, remove it
        if (deleted && !node.isEnd && isEmpty(node.children)) {
            node.children[charIndex] = null;
        }

        return deleted;
    }

    private boolean isEmpty(TrieNode[] children) {
        for (TrieNode child : children)
            if (child != null)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert keys
        trie.insert("bat");
        trie.insert("batman");
        trie.insert("batwoman");

        // Search keys
        System.out.println(trie.search("bat"));      // true
        System.out.println(trie.search("batman"));   // true
        System.out.println(trie.search("batwoman")); // true
        System.out.println(trie.search("bats"));     // false

        // Delete key
        trie.delete("bat");
        System.out.println(trie.search("bat"));      // false
        System.out.println(trie.search("batman"));   // true
        System.out.println(trie.search("batwoman")); // true
    }
}
