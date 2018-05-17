package com.ankit.problems;

public class TrieExample {

	static final int CHAR_SIZE = 26;
	TrieNode head = new TrieNode();
	
	public void insert(String s) {
		TrieNode curHead = head;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			int position = c - 'a';
			TrieNode node = new TrieNode();
			if(i == s.length()-1) {
				node.isWordEnd = true;
			}
			curHead.children[position] = node;
			curHead = node;
		}
	}
	
	public boolean search(String s) {
		TrieNode curr = head;
		for(int i=0;i<s.length();i++) {
			int index = s.charAt(i) - 'a';
			TrieNode child = curr.children[index];
			if(child == null) {
				return false;
			}
			curr = child;
		}
		return curr!=null && curr.isWordEnd;
	}
	public void delete(String s) {
		TrieNode curr = head;
//		for(int i=0;i<s.length();i++) {
//			int index = s.charAt(i) - 'a';
//			TrieNode child = curr.children[index];
//			if(child == null) {
//				return false;
//			}
//			curr = child;
//		}
		delete(curr,s,0);
	}
	private void delete(TrieNode node, String s, int index) {
		if(node == null || index >= s.length()) {
			return;
		}
		int pos = s.charAt(index)-'a';
		TrieNode nodeC = node.children[pos];
		delete (nodeC, s, ++index);
		node.children[pos]=null;
	}
	public void printAllWords() {
		String s = print(head,-1);
		System.out.println(s);
	}
	private String print(TrieNode node, int index) {
		String s = "";
		if(node == null) {
			return s;
		}
		if(node.isWordEnd) {
			char c = (char)('a'+ index);
			s = c + s;
			
		}
		for(int i=0;i<node.children.length;i++) {
			TrieNode nodeC = node.children[i];
			s=print(nodeC,i)+s;
		}
		//System.out.println(s);
		if(index!=-1) {
			char c = (char)('a'+ index);
			s = c + s;
		}
		return s;
	}
	public static void main(String[] args) {
		TrieExample te = new TrieExample();
		te.insert("ankit");
		//te.insert("an");
		System.out.println(te);
		te.printAllWords();
		System.out.println(te.search("ankit"));
		te.delete("ankit");
		System.out.println(te.search("ankit"));
	}
	
}
class TrieNode{
	TrieNode children []= new TrieNode[TrieExample.CHAR_SIZE];
	boolean isWordEnd;
	public TrieNode() {
		for(int index=0;index<children.length;index++) {
			children[index] = null;
		}
	}
	@Override
	public String toString() {
		return "TrieNode [children=" + children + ", isWordEnd=" + isWordEnd + "]";
	}
	
}