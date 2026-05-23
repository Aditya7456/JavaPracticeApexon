package com.practice.tries;

import java.util.ArrayList;
import java.util.List;

 class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd;
    TrieNode(){
        isWordEnd = false;
    }
}

public class TrieImplementation {

    TrieNode root;

    public  TrieImplementation(){
       root = new TrieNode();
    }

    // to insert in trie
    public void insert(String word){
        TrieNode curr = root;
        // traversing entire string and putting this in the trie
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            // if there is nothing at that index then putting new node
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr=curr.children[index];
        }
        curr.isWordEnd=true;
    }
    // to search word in trie
    public boolean search(String word){
        TrieNode curr = root;
        for(char ch:word.toCharArray()){
            int index = ch - 'a';
            // if there is no node at index then word is not there
            if(curr.children[index]==null) return false;
            // else
            curr=curr.children[index];
        }
        return curr.isWordEnd;
    }
    // to check if any word startsWith the given string
    public boolean startsWith(String prefix){
        TrieNode curr = root;
        for(char ch:prefix.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null) return false;
            curr=curr.children[index];
        }
        return true;
    }
    // to return all the string matches with the given prefix(AutoComplete feature)
    public List<String> getAllWordsWithPrefix(String word){
        List<String> result = new ArrayList<>();
        TrieNode curr = root;
        for(char ch:word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index]==null) return result; // not matches
            curr=curr.children[index];
        }
        // now let's dfs from prefix node
        dfs(curr,word,result);
        return result;
    }
    public void dfs(TrieNode node, String word, List<String> result){
        // if anytime i reach the word, I will add that to the result
        if(node.isWordEnd) result.add(word);
        for(int i=0; i<26; i++){
            if(node.children[i]!=null){
                dfs(node.children[i],word + (char)(i+'a'),result);
            }
        }
    }

}
