package com.practice.tries;

public class TrieDemo {
    public static void main(String[] args){
        TrieImplementation trie = new TrieImplementation();
        trie.insert("aditya");
        trie.insert("aman");
        trie.insert("adverse");
        trie.insert("rahul");
        trie.insert("cat");
        trie.insert("car");
        trie.insert("cart");
        trie.insert("dog");
        //System.out.println(trie.startsWith("adr"));
        System.out.println(trie.getAllWordsWithPrefix("car"));
    }
}
