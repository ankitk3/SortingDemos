package com.ankit.problems;

import java.util.HashMap;

/**
 * Create a map with LinkedHashMap like functionality, in which we need to maintain access order
 * We need to print all keys in insertion order
 * We need to print all values in insertion order.
 */
public class MicrosoftQuestionThree {
    static class Entry{
        Object key;
        Object value;
        Entry next; // this will keep a reference of next entry
        Entry previous;

        public Entry(){

        }
        public Entry(Object key, Object value, Entry next, Entry previous) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
    static class CustomizedMap extends HashMap {
        private MicrosoftQuestionThree.Entry root;
        private MicrosoftQuestionThree.Entry tail;
        public void putValue(Object key, Object value){
            if(root == null){
                root = new MicrosoftQuestionThree.Entry(key, value, null, null);//if root is empty put the first value
                tail = root;
            } else{
                MicrosoftQuestionThree.Entry node = new MicrosoftQuestionThree.Entry();
                node.key = key;
                node.value = value;
                tail.next = node;
                node.previous = tail;
                tail = node;
                //node.next = root;
                //root = node;
            }
            putEntry(key,value);
        }

        //Assuming this will put entry in hashmap bucket.
        private void putEntry(Object key, Object value) {
        }

        public void removeValue(Object key){
            MicrosoftQuestionThree.Entry currentNode = getEntry(key); // Assuming this will provide entry by key
            MicrosoftQuestionThree.Entry previous = currentNode.previous;
            previous.next = currentNode.next;
            currentNode.previous = previous;
            removeEntry(key);
        }

        //Assuming this will remove entry from hashmap bucket.
        private void removeEntry(Object key) {
        }

        //Assuming it returns entry by given key
        private MicrosoftQuestionThree.Entry getEntry(Object key) {
            return new MicrosoftQuestionThree.Entry();
        }

        public void printKey(){
            if(root != null){
                while(root.next != null){
                    System.out.println(root.key);
                }
            }
        }
        public void printValue(){
            if(root != null){
                while(root.next != null){
                    System.out.println(root.value);
                }
            }
        }
    }
}
