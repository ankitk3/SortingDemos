package com.ankit.problems.wynk;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Sort a singly linked list till kth element
 * @author ankit
 *
 */
public class SortLinkListTillK {

	static SinglyLinkedListNode sortList(SinglyLinkedListNode head, int k) {
		SinglyLinkedListNode curr = head;
		int i = 0;
		while (i < k-1) {
			if (curr == null) {
				throw new RuntimeException(k + "th element not present");
			}
			curr = curr.next;
			i++;
		}
		SinglyLinkedListNode tail = curr;
		SinglyLinkedListNode tailNext = curr.next;
		tail.next = null;
		SinglyLinkedListNode sortNode = mergeSort(head);
		curr = sortNode;
		SinglyLinkedListNode previous = curr;
		while(curr!=null) {
			previous = curr;
			curr = curr.next;
		}
		previous.next = tailNext;
		return sortNode;
	}

	private static SinglyLinkedListNode sortedMerge(SinglyLinkedListNode a, SinglyLinkedListNode b) 
    {
		SinglyLinkedListNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;
 
        /* Pick either a or b, and recur */
        if (a.data <= b.data) 
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        } 
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
 
    }
	private static SinglyLinkedListNode mergeSort(SinglyLinkedListNode h) {
		// Base case : if head is null
		if (h == null || h.next == null) {
			return h;
		}

		// get the middle of the list
		SinglyLinkedListNode middle = getMiddle(h);
		SinglyLinkedListNode nextofmiddle = middle.next;

		// set the next of middle node to null
		middle.next = null;

		// Apply mergeSort on left list
		SinglyLinkedListNode left = mergeSort(h);

		// Apply mergeSort on right list
		SinglyLinkedListNode right = mergeSort(nextofmiddle);

		// Merge the left and right lists
		SinglyLinkedListNode sortedlist = sortedMerge(left, right);
		return sortedlist;
	}
	// Utility function to get the middle of the linked list
	private static SinglyLinkedListNode getMiddle(SinglyLinkedListNode h) 
    {
        //Base case
        if (h == null)
            return h;
        SinglyLinkedListNode fastptr = h.next;
        SinglyLinkedListNode slowptr = h;
         
        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null)
        {
            fastptr = fastptr.next;
            if(fastptr!=null)
            {
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
    }
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/tmp/abc.txt"));

		SinglyLinkedList head = new SinglyLinkedList();

		int headCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		for (int headItr = 0; headItr < headCount; headItr++) {
			int headItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

			head.insertNode(headItem);
		}

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		SinglyLinkedListNode res = sortList(head.head, k);

		printSinglyLinkedList(res, "\n", bufferedWriter);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();*/
		SinglyLinkedListNode node = new SinglyLinkedListNode(5);
		node.next = new SinglyLinkedListNode(3);
		node.next.next = new SinglyLinkedListNode(2);
		node.next.next.next = new SinglyLinkedListNode(4);
		node.next.next.next.next = new SinglyLinkedListNode(1);
		node.next.next.next.next.next = new SinglyLinkedListNode(2);
		SinglyLinkedListNode res = sortList(node, 4);
		while(res!=null) {
			System.out.println(res.data);
			res = res.next;
		}
	}
}
