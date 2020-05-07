package com.ankit.LeetCodeMayChallenge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *          1
 *         / \
 *        2   3
 *       /
 *      4
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 */
public class May7Problem {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
   }
    public boolean isCousins(TreeNode root, int x, int y) {
        long start = System.currentTimeMillis();
        boolean isXFound = false, isYFound = false;
        boolean isNotLastElement = true;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
            queue.add(null);
        }
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node != null){
                isNotLastElement = false;
                if(node.left != null && node.right != null && ((node.left.val == x && node.right.val == y)
                        || (node.left.val == y && node.right.val == x))){
                    //parent is same for both nodes.
                    return false;
                }
                if(node.val == x){
                    isXFound = true;
                } else if(node.val == y){
                    isYFound = true;
                }
                if(isXFound && isYFound){
                    long endTime = System.currentTimeMillis();
                    long lapsed = (endTime-start);
                    System.out.println("Time taken in miliseconds = "+lapsed);
                    return true;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            } else{
                isXFound = false;
                isYFound = false;
                if(!isNotLastElement){
                    queue.add(null);
                    isNotLastElement = true;
                }
                continue;
            }
        }
        long endTime = System.currentTimeMillis();
        long lapsed = (endTime-start);
        System.out.println("Time taken in miliseconds = "+lapsed);
        return false;
    }

    public static void main(String[] args) {
        May7Problem obj = new May7Problem();
        TreeNode input = new TreeNode();
        input.val = 1;
        TreeNode left = new TreeNode();
        left.val = 2;
        TreeNode right = new TreeNode();
        right.val = 3;
        input.left = left;
        input.right = right;
        left = new TreeNode();
        left.val = 4;
        right = new TreeNode();
        right.val = 5;
        input.left.left = left;
        input.right.right = right;
        boolean response = obj.isCousins(input, 4, 6);
        System.out.println(response);
    }
}
