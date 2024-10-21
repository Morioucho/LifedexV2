package com.morioucho.lifedexv2.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private final TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String[] words){
        for(String word : words){
            root.insert(word);
        }
    }

    public void insert(String word) {
        if(word == null || word.isEmpty()){
            return;
        }

        root.insert(word);
    }

    public boolean find(String prefix){
        TrieNode currNode = this.root;

        for(char c : prefix.toCharArray()){
            currNode = currNode.getChildren().get(c);

            if(currNode == null){
                return false;
            }
        }

        return currNode.isWordEnd();
    }

    public List<String> suggestions(String prefix){
        List<String> suggestions = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        TrieNode currNode = this.root;

        for(char c : prefix.toCharArray()){
            currNode = currNode.getChildren().get(c);

            if(currNode == null){
                return suggestions;
            }

            buffer.append(c);
        }

        suggest(currNode, suggestions, buffer);

        return suggestions;
    }

    public void suggest(TrieNode node, List<String> suggestions, StringBuilder buffer){
        if(node.isWordEnd()){
            suggestions.add(buffer.toString());
        }

        if(node.getChildren() == null || root.getChildren().isEmpty()){
            return;
        }

        for(){

        }
    }
}
