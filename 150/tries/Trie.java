// 63
public class Trie {

    Trie[] children;
    boolean isWordEnd;

    public Trie() {
        children = new Trie[26];
        isWordEnd = false;
    }

    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("apple");
        boolean result = trie.search("apple");
        boolean prefixFound = trie.prefix("pl");
        System.out.println("Element found: " + result);
        System.out.println("Prefix found: " + prefixFound);
    }

    public boolean prefix(String word) {
        Trie currentNode = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return true;
    }

    public void insert(String word) {
        Trie currentNode = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // for a=0, b=1, c=2
            if (currentNode.children[index] == null)
                currentNode.children[index] = new Trie();
            // Move to trie node that present at index
            currentNode = currentNode.children[index];
        }
        currentNode.isWordEnd = true;
    }

    public boolean search(String word) {
        Trie currentNode = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isWordEnd;
    }
}