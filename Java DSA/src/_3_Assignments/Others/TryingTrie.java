package _3_Assignments.Others;

import java.util.*;

/*
    Implement using TrieNode array instead of HashMap
    Implement the 'delete' method
*/

public class TryingTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"Round", "Rack", "Run", "Rest", "Rare", "Rash", "Rug", "Reek", "Bye", "Buoy", "Bar"};
        for(String word: words) trie.addWord(word);
        System.out.println(trie);
        String[] queries = {"Rack", "Rune", "Rage", "Rou", "Re", "Rarer", "Bar", "By"};
        System.out.println("Queries: " + Arrays.toString(queries));
        System.out.print("Found: ");
        for(String query: queries) System.out.print(trie.search(query) + " ");
    }
}

class Trie {

    private static class TrieNode {
        private final Map<Character, TrieNode> children;
        public TrieNode() {
            children = new HashMap<>();
        }
        public TrieNode get(char key) {
            return this.children.getOrDefault(key, null);
        }
        public void add(char key, TrieNode node) {
            this.children.put(key, node);
        }
        public Set<Character> keySet() {
            return this.children.keySet();
        }
    }

    private final TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    public void addWord(String str) {
        int index = 0;
        TrieNode node = this.rootNode, lastNode = null;
        while(index < str.length() && node != null) {
            char ch = str.charAt(index);
            lastNode = node;
            node = node.get(ch);
            index++;
        }
        if(index <= str.length()) addNewChars(index - 1, str, lastNode);
    }

    private void addNewChars(int index, String str, TrieNode lastNode) {
        while(index < str.length()) {
            TrieNode newNode = new TrieNode();
            lastNode.add(str.charAt(index), newNode);
            index++;
            lastNode = newNode;
        }
    }

    public boolean search(String str) {
        int index = 0;
        TrieNode node = this.rootNode;
        while(index < str.length()) {
            char ch = str.charAt(index);
            node = node.get(ch);
            if(node == null) return false;
            index++;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        trieBFS(sb);
        return sb.toString();
    }

    private void trieBFS(StringBuilder sb) {
        Map<TrieNode, Character> trieNodeVal = new HashMap<>();

        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(this.rootNode);
        trieNodeVal.put(this.rootNode, '.');
        int level = 0, lastSize = queue.size();

        while(!queue.isEmpty()) {
            TrieNode trieNode = queue.poll();
            lastSize--;
            Set<Character> keys = trieNode.keySet();
            char val = trieNodeVal.get(trieNode);
            sb.append("(Level: ").append(level).append(") ")
                    .append((val == '.')? "root": val)
                    .append(": ")
                    .append(keys)
                    .append("\n");
            for(char key: keys) {
                TrieNode node = trieNode.get(key);
                trieNodeVal.put(node, key);
                queue.add(node);
            }
            if(lastSize == 0) {
                level++;
                lastSize = queue.size();
            }
        }
    }
}
