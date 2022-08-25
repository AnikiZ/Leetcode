/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-24 15:22:02
 * @LastEditTime: 2022-08-24 15:51:40
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/ImplementTrie_PrefixTree_208.java
 */
package Tree;

public class ImplementTrie_PrefixTree_208 {
    
    class Trie {

        private Trie[] children;
        private Boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
        
        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
        
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd == true;
        }
        
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
