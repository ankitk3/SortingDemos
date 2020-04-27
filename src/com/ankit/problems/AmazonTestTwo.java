package com.ankit.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  *
 *  *
 * Name: <Ankit Kalra>
 *
 * Time limit = 1 hr
 *
 * Instructions :
 *     * Write production-ready code for each question by handling all edge cases.
 *     * No need to read the Input.
 *     * Assume Inputs are passed as Parameters to functions.
 *     * Write the functional Implementation for each question.
 *     * Use programming language of your choice.
 *     * No need to implement any Inbuilt Functions (Eg : sort() ) if you are using.
 *     * Solve each question with best time and space complexity possible.
 *     * This platform does not let you compile or test the code.
 *     * You can manually go through your code for the example test cases.
 *     * No need to submit. You can close the window when you are done.
 *
 *
 *
 *
         *QUESTION 2
         * ===========
         *
         *Given a binary tree print the diagonal sum.
         *
         *For the below tree:
         *
         *1
         *
         *2 3
         *
         *4 5 6 7
         *
         *Diagonal sums are as below:
         *
         *1+3+7=11
         *2+5+6=13
         *4=4
         *
         *So you have to print 11,13,4(order is not important)
         *
         *Please write working code and your solution should handle all edge cases.
 */
public class AmazonTestTwo {

    private List<Integer> diagonalSum(Node node){
        List<Integer> totalSumList = new ArrayList<>();
        Map<Integer,List<Integer>> sumListMap = new HashMap<>();
        if(node != null){
            processElements(node, 0, sumListMap);
        }
        //since order is not important, any diagonal is printed first, since it is Hashmap.
        for(Map.Entry<Integer,List<Integer>> diagonalElementsEntry : sumListMap.entrySet()){
            int sum = 0;
            List<Integer> sumList = diagonalElementsEntry.getValue();
            if(sumList != null){
                for(Integer element : sumList){
                    sum += element;
                }
            }
            totalSumList.add(sum);
        }
        return totalSumList;
    }
    private void processElements(Node node, int distance, Map<Integer,List<Integer>> sumListMap){
        if(node != null){
            List<Integer> sumList = sumListMap.get(distance);
            if(sumList == null){
                sumList = new ArrayList<Integer>();
            }
            sumList.add(node.data);
            sumListMap.put(distance,sumList);
            if(node.right != null){
                //if right is available, it should be printed with parent
                processElements(node.right,distance, sumListMap);
            }
            //if left is available, it should be printed with other parent
            if(node.left != null){
                processElements(node.left, distance+1, sumListMap);
            }
        }


    }
    public static void main(String[] args) {
        AmazonTestTwo obj = new AmazonTestTwo();
        Node node = new Node();
        node.data=10;
        Node left = new Node();
        left.data = 8;
        Node right = new Node();
        right.data = 12;
        node.left = left;
        node.right = right;

        left = new Node();
        left.data = 7;
        right = new Node();
        right.data = 9;
        node.left.left=left;
        node.left.right=right;

        left = new Node();
        left.data = 11;
        right = new Node();
        right.data = 133;
        node.right.left=left;
        node.right.right=right;

        List<Integer> list= obj.diagonalSum(node);
        for(int i : list){
            System.out.println(i);
        }
    }
    static class Node{
        int data;
        Node left;
        Node right;
    }
}
