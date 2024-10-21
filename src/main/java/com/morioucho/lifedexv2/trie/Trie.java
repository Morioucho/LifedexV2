package com.morioucho.lifedexv2.trie;

public class Trie {
    private final TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;

        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);

            if(curr.getChildren()[letter - 'a'] == null){
                curr.getChildren()[letter - 'a'] = new TrieNode();
            }

            curr = curr.getChildren()[letter - 'a'];
        }

        curr.setEnd(true);
    }
}
