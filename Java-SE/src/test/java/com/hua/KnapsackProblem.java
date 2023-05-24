package com.hua;

//动态规划
public class KnapsackProblem {

    public static void main(String[] args) {

        int[] weights = { 1, 2, 3, 4, 5 };
        int[] values = { 5, 7, 2, 4, 9 };
        int capacity = 10;

        int result = knapsack(weights, values, capacity);
        System.out.println("The maximum value that can be carried is: " + result);
    }

    public static int knapsack(int[] w, int[] v, int capacity) {

        int[][] dp = new int[w.length + 1][capacity + 1];

        for (int i = 0; i <= w.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (w[i-1] <= j) {
                    dp[i][j] = Math.max(v[i-1] + dp[i-1][j-w[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[w.length][capacity];
    }
}

