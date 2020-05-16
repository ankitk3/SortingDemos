package com.ankit.LeetCodeMayChallenge;

import java.util.List;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class May16Problem {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next ==  null){
            return head;
        }
        ListNode odd = null;
        ListNode even = null;
        ListNode oddFirst = null;
        ListNode evenFirst = null;
        ListNode node = head.next;
        int index = 2;
        while(node != null){
            if(index % 2 == 0){
                if(even == null){
                    even = node;
                    evenFirst = node;
                } else{
                    even.next = node;
                    even = node;
                }
            } else{
                if(odd == null){
                    odd = node;
                    oddFirst = node;
                } else{
                    odd.next = node;
                    odd = node;
                }
            }
            index++;
            node = node.next;
        }
        if(oddFirst != null){
            head.next = oddFirst;
            odd.next = evenFirst;
        } else{
            head.next = evenFirst;
        }
        if(even!= null){
            even.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        May16Problem obj = new May16Problem();
        ListNode input = new ListNode();
        input.val=2;
        ListNode next = new ListNode();
        next.val = 1;
        input.next = next;
        next = new ListNode();
        next.val = 3;
        input.next.next = next;
        next = new ListNode();
        next.val = 5;
        input.next.next.next = next;
        next = new ListNode();
        next.val = 6;
        input.next.next.next.next = next;
        next = new ListNode();
        next.val = 4;
        input.next.next.next.next.next = next;
        next = new ListNode();
        next.val = 7;
        input.next.next.next.next.next.next = next;
        ListNode resp = obj.oddEvenList(input);
        while(resp != null){
            System.out.println(resp.val);
            resp = resp.next;
        }
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
