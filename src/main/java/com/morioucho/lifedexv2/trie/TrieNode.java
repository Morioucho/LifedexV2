package com.morioucho.lifedexv2.trie;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TrieNode {
    private boolean wordEnd;
    private char c;

    private Map<Character, TrieNode> children;

    public TrieNode(char c){
        this.c = c;
        this.children = new HashMap<>();
    }

    public TrieNode() {}
}
