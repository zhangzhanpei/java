```java
//一个文件中可以定义多个class，但只能有一个class用public声明
//TrieNode类与文件名不同，则编译出来的是TrieNode.class
class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    //一个类可以有多个构造函数(参数不同)
    TrieNode() {}

    //构造函数可用public声明，默认没有public时是protected即包内可访问
    TrieNode(char c) {
        TrieNode t = new TrieNode();
        t.val = c;
    }
}

//声明为public的class类名必须与文件名相同
public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
        this.root.val = ' ';
    }

    public void insert(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }


    public boolean search(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }


    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return true;
    }
}
```