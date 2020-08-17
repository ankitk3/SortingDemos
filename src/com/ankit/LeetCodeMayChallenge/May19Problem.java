package com.ankit.LeetCodeMayChallenge;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 *
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 *
 *
 *
 * Example 1:
 *
 * Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * Output: [null,1,1,1,2,1,4,6]
 * Explanation:
 * First, S = StockSpanner() is initialized.  Then:
 * S.next(100) is called and returns 1,
 * S.next(80) is called and returns 1,
 * S.next(60) is called and returns 1,
 * S.next(70) is called and returns 2,
 * S.next(60) is called and returns 1,
 * S.next(75) is called and returns 4,
 * S.next(85) is called and returns 6.
 *
 * Note that (for example) S.next(75) returned 4, because the last 4 prices
 * (including today's price of 75) were less than or equal to today's price.
 *
 *
 * Note:
 *
 * Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
 * There will be at most 10000 calls to StockSpanner.next per test case.
 * There will be at most 150000 calls to StockSpanner.next across all test cases.
 * The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 */
public class May19Problem {

    private Stack<Integer> st;
    private int [] s;
    int index = 0;
    public May19Problem(){
        st = new Stack<>();
        s = new int[7];
    }
    public int next(int price) {
        if(st.size() == 0){
            s[index++] = 1;
            st.push(price);
        } else{
            //for (int i = 1; i < n; i++) {

                // Pop elements from stack while stack is not
                // empty and top of stack is smaller than
                // price[i]
                while (!st.empty() && price[st.peek()] <= price[i])
                    st.pop();

                // If stack becomes empty, then price[i] is
                // greater than all elements on left of it, i.e.,
                // price[0], price[1], ..price[i-1]. Else price[i]
                // is greater than elements after top of stack
                S[i] = (st.empty()) ? (i + 1) : (i - st.peek());

                // Push this element to stack
                st.push(pricez);
            //}
        }

    }

    public static void main(String[] args) {
        May19Problem obj = new May19Problem();
        int resp = obj.next(100);
        System.out.println(resp);
        resp = obj.next(80);
        System.out.println(resp);
        resp = obj.next(60);
        System.out.println(resp);
        resp = obj.next(70);
        System.out.println(resp);
        resp = obj.next(60);
        System.out.println(resp);
        resp = obj.next(75);
        System.out.println(resp);
        resp = obj.next(85);
        System.out.println(resp);
    }
}
