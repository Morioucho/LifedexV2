package com.morioucho.lifedexv2.trie;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Trie {
    private final TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode curr = this.root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if (!curr.getChildren().containsKey(ch)) {
                curr.getChildren().put(ch, new TrieNode());
            }

            curr = curr.getChildren().get(ch);
        }
    }

    public boolean exists(String word){
        TrieNode curr = this.root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if(!curr.getChildren().containsKey(ch)){
                return curr.isWordEnd();
            }

            curr = curr.getChildren().get(ch);
        }

        return true;
    }

    public List<String> getAllFromPrefix(String prefix){
        List<String> found = new ArrayList<>();

        TrieNode curr = this.root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);

            if(!curr.getChildren().containsKey(ch)){
                return found;
            }

            curr = curr.getChildren().get(ch);
        }

        collectAllWords(curr, new StringBuilder(prefix), found);

        return found;
    }

    private void collectAllWords(TrieNode node, StringBuilder prefix, List<String> found) {
        if (node.isWordEnd()) {
            found.add(prefix.toString());
        }

        for (Map.Entry<Character, TrieNode> entry : node.getChildren().entrySet()) {
            prefix.append(entry.getKey());
            collectAllWords(entry.getValue(), prefix, found);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}