package com.ankit.problems;

/**
 * Find whether a sum exists in given tree path.
 * Path has to be continuous, means you can not skip a node in between, while calculating sum
 * Path can start from anywhere, not restricted to root only.
 */
public class MicrosoftQuestionTwo {

    static class Node{
        int value;
        Node left;
        Node right;
    }
    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.

        Node root = new Node();
        root.value = 5;
        Node left = new Node();
        left.value = 2;
        Node right = new Node();
        right.value = 3;
        root.left = left;
        root.right = right;

        left = new Node();
        left.value = 3;
        right = new Node();
        right.value = 1;
        root.left.left = left;
        root.left.right = right;



        left = new Node();
        left.value = 4;
        right = new Node();
        right.value = 1;
        root.left.left.left = left;
        root.left.left.right = right;

        MicrosoftQuestionTwo solution = new MicrosoftQuestionTwo();
        boolean output = solution.chechSumExists(root,12);
        System.out.println(output);
    }

    private boolean chechSumExists(Node node, long sum){
        if(node == null){
            return false;
        }
        return calculateSum(node, 0, sum);
    }
    //recursive method to calculate and check sum
    private boolean calculateSum(Node node, long currentSum, long sum){
        if(node == null){
            return false;
        }
        //if(currentSum == sum){
        //  return true;
        //}
        if(node.value+currentSum == sum){
            return true;
        }

        //if(node.left != null && node.left.value+currentSum == sum){
        //  return true;
        //}
        //if(node.right != null && node.right.value+currentSum == sum){
        //  return true;
        //}
        return calculateSum(node.left,node.value+currentSum, sum) // calling with left with currentSum is as total of parent
                || calculateSum(node.right,node.value+currentSum, sum) //calling with right with currentSum is as total of parent
                || calculateSum(node.left,0, sum)  //calling with left with currentSum is as node value
                || calculateSum(node.right,0, sum);//calling with right with currentSum is as node value
    }
}
