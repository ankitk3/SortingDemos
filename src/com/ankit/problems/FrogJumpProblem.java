package com.ankit.problems;

import java.util.Arrays;

/**
 * @Refer : https://leetcode.com/problems/frog-jump/
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 */
public class FrogJumpProblem {

    public boolean canCross(int[] stones) {
        return check(2,stones);
    }
    private boolean check(int stone, int[] stones){
        if(stone > 1100 || stone < 2 || stone > stones[stones.length-1]){
            return false;
        }
       // int stone = stones[index];
        if(isLast(stone,stones)){
            System.out.println("Returning true of last element "+stone);
            return true;
        }
        if(isContain(stone,stones)){
            return check(++stone, stones) || check(--stone, stones);
        }
        return false;
    }
    private boolean isContain(final int stone, int[]stones){
        for(int i : stones){
            if(i == stone)
                return true;
        }
        return false;
//        return Arrays.stream(stones).anyMatch( ab -> ab == stone);
    }
    private boolean isLast(final int stone, int [] stones){
        return stones[stones.length-1]== stone;
//        return Arrays.stream(stones).skip(stones.length-1).anyMatch(ab -> ab == stone);
    }
    public static void main(String[] args) {
//        int [] stones = {0,1,3,5,6,8,12,17};
        int [] stones = {0,1,2,3,4,8,9,11};
        FrogJumpProblem pb = new FrogJumpProblem();
        boolean result = pb.canCross(stones);
        System.out.println(result);
    }

}
