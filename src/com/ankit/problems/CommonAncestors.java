package com.ankit.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Find common ancestors between two nodes
 * @author ankit
 *
 */
//TODO to write code
public class CommonAncestors {

	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
		}
	}
	private List<Integer> leftList = new ArrayList<>();
	private List<Integer> rightList = new ArrayList<>();
	public void findCommon(Node n, int left, int right) {
		if(n == null) {
			return;
		}
		
		findCommon(n.left, left, right);
	}
	public static void main(String[] args) {
		Node n = new Node(0);
		n.left=new Node(5);
		n.right=new Node(7);
		n.left.left=new Node(6);
		n.left.right=new Node(8);
		n.right.left=new Node(9);
		n.right.right=new Node(10);
		printTree(n);
	}
	public static void printTree(Node n) {
		if(n!=null) {
			System.out.println(n.data);
			System.out.println();
			printTree(n.left);
			System.out.print("\t");
			printTree(n.right);
		}
	}
}
