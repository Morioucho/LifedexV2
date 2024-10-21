package com.morioucho.lifedexv2.trie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        this.isEnd = false;
        this.children = new TrieNode[26];
    }
}
