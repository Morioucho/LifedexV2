package com.morioucho.lifedexv2.trie;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TrieNode {
    boolean wordEnd;
    char c;

    Map<Character, TrieNode> children;

    public TrieNode(char c){
        this.c = c;
        this.children = new HashMap<>();
    }

    public TrieNode(){}

    public void insert(String word){
        if(word == null || word.isEmpty()){
            return;
        }

        char currChar = word.charAt(0);
        TrieNode child = this.children.get(currChar);

        if(child == null){
            child = new TrieNode(currChar);

            this.children.put(currChar, child);
        }

        if(word.length() > 1){
            child.insert(word.substring(1));
        } else {
            child.setWordEnd(true);
        }
    }
}
