class TrieNode {
    char character;
    TrieNode[] children;
    boolean isWordEnding;
    
    public TrieNode(char character) {
        this.character = character;
        children = new TrieNode[26];
        isWordEnding = false;
    }
}

public class DesignTrie {
    TrieNode rootNode;
    public DesignTrie() {
        this.rootNode = new TrieNode(' ');
    }
    
    public void insert(String word) {
        TrieNode tempNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (tempNode.children[index] == null) {
                tempNode.children[index] = new TrieNode(word.charAt(i));
            }
            tempNode = tempNode.children[index];
            if(i == word.length() - 1) {
                tempNode.isWordEnding = true;
            }
        }
    }
    
    public boolean search(String word) {
        TrieNode tempNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (tempNode.children[index] != null) {
                tempNode = tempNode.children[index];
                if(i == word.length() - 1 && tempNode.isWordEnding) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode tempNode = rootNode;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (tempNode.children[index] != null) {
                tempNode = tempNode.children[index];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String words[] = new String[]{"abc", "abb", "bca", "bbb"};
        DesignTrie trie = new DesignTrie();
        for(String word : words) {
            trie.insert(word);
        }

        String searchWords[] = new String[]{"abc", "abb", "bac", "bbb"};
        for(String word : searchWords) {
            System.out.print(trie.search(word)+ " ");
        }
        System.out.println();
        String startsWith[] = new String[]{"a", "ba", "bc", "bb"};
        for(String word : startsWith) {
            System.out.print(trie.startsWith(word) + " ");
        }
    }
    
}
