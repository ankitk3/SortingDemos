package com.ankit.LeetCodeMayChallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class May14Problem {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("app");
        obj.insert("apple");
        obj.insert("beer");
        obj.insert("add");
        obj.insert("jam");
        obj.insert("rental");
        System.out.println(obj.search("apps"));
        System.out.println(obj.search("app"));
        System.out.println(obj.search("ad"));
        System.out.println(obj.search("applepie"));
        System.out.println(obj.search("rest"));
        System.out.println(obj.search("jan"));
        System.out.println(obj.search("rent"));
        System.out.println(obj.search("beer"));
        System.out.println(obj.search("jam"));
        System.out.println(obj.startsWith("apps"));
        System.out.println(obj.startsWith("app"));
        System.out.println(obj.startsWith("ad"));
        System.out.println(obj.startsWith("applepie"));
        System.out.println(obj.startsWith("rest"));
        System.out.println(obj.startsWith("jan"));
        System.out.println(obj.startsWith("rent"));
        System.out.println(obj.startsWith("beer"));
        System.out.println(obj.startsWith("jam"));
    }
}
 class Trie {

    Trie[] trieArr;
    List<String> words;
    /** Initialize your data structure here. */
    public Trie() {
        trieArr = new Trie[26];
        words = new ArrayList<>();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trie = this;
        for(char cc : word.toCharArray()){
            int index = cc - 'a';
            Trie obj;
            if(trie.trieArr[index] == null) {
                obj = new Trie();
            }else{
                obj = trie.trieArr[index];
            }
            obj.words.add(word);
            trie.trieArr[index] = obj;
            trie = obj;
        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = this;
        for(char cc : word.toCharArray()){
            int index = cc - 'a';
            trie = trie.trieArr[index];
            if(trie == null){
                break;
            }
        }
        if(trie == null){
            return false;
        } else{
            return trie.words.contains(word);
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        boolean result = true;
        Trie trie = this;
        for(char cc : prefix.toCharArray()){
            int index = cc - 'a';
            trie = trie.trieArr[index];
            if(trie == null){
                result = false;
                break;
            }
        }
        return result;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
