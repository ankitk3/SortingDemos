package com.ankit.problems;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraverseTree {

	private Queue<Node> queue = new LinkedList<>();
	static class Node{
		int value;
		Node left;
		Node right;
	}
	private void process(Node node) {
		if(node == null) {
			return ;
		}
		System.out.println(node.value);
		queue.add(node.left);
		queue.add(node.right);
		process(queue.poll());
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
		new BFSTraverseTree().process(node);
	}
}
