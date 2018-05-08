package com.ankit.problems;

import java.util.LinkedList;
import java.util.Queue;

public class DFSTraverseTree {

	//private Queue<Node> queue = new LinkedList<>();
	static class Node{
		int value;
		Node left;
		Node right;
	}
	private void inorder(Node node) {
		if(node == null) {
			return ;
		}
		inorder(node.left);
		System.out.print(node.value+" ");
		inorder(node.right);
	}
	private void preorder(Node node) {
		if(node == null) {
			return ;
		}
		System.out.print(node.value+" ");
		preorder(node.left);
		preorder(node.right);
	}
	private void postorder(Node node) {
		if(node == null) {
			return ;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value+" ");
	}
	public static void main(String[] args) {
		Node node = new Node();
		node.value=20;
		node.left = new Node();
		node.left.value = 10;
		node.right = new Node();
		node.right.value = 30;
		node.left.left = new Node();
		node.left.left.value = 5;
		node.left.right = new Node();
		node.left.right.value = 8;
		node.right.left = new Node();
		node.right.left.value = 25;
		node.right.right = new Node();
		node.right.right.value = 35;
		DFSTraverseTree dt = new DFSTraverseTree();
		dt.inorder(node);
		System.out.println();
		dt.preorder(node);
		System.out.println();
		dt.postorder(node);
	}
}
