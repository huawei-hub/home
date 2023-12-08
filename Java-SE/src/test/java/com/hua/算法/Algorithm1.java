package com.hua.算法;

import org.junit.Test;

public class Algorithm1 {

    //斐波那契数-递归
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        System.out.println(fibonacci2(30));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    private int fibonacci1(int n) {
        if (n <= 1)
            return n;
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }
    private int fibonacci2(int n) {
        if (n <= 1)
            return n;
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    //旋转数组的最小数字
    @Test
    public void test2() {
        int[] arr = new int[]{2, 3, 4, 1};
        System.out.println(minNumberInRotateArray(arr));
    }
    public int minNumberInRotateArray(int[] nums) {
        if (nums.length < 1)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] <= nums[m]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
    //矩阵中的路径
    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    @Test
    public void test3(){
        String val = "ABCESFCSADEE";
        int rows = 3;
        int cols = 4;
        String path = "ABCCED";
        boolean res = hasPath(val, rows, cols, path);
        System.out.println(res);
    }
    private boolean hasPath (String val, int rows, int cols, String path) {
        if (rows==0&& cols==0)
            return false;
        char[][] matrix = buildMatrix(val, rows, cols);
        char[] pathList = path.toCharArray();
        boolean[][] marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix, pathList, marked, 0, i, j))
                    return true;
        return false;
    }
    private boolean backtracking(char[][] matrix, char[] pathList, boolean[][] marked, int pathLen, int r, int c) {
        if (r < 0 || r >= marked.length || c < 0 || c >= marked[0].length ||
                matrix[r][c] != pathList[pathLen] || marked[r][c])
            return false;
        marked[r][c] = true;
        for (int[] n : next) {
            if (backtracking(matrix, pathList, marked, pathLen + 1, r + n[0], r + n[1]))
                return true;
        }
        marked[r][c] = false;
        return false;
    }
    private char[][] buildMatrix(String val, int rows, int cols) {
        char[] valChar = val.toCharArray();
        char[][] matrix = new char[cols][rows];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix[c][r] = valChar[c * rows + r];
        return matrix;
    }

    //剪绳子
    @Test
    public void test4() {
        System.out.println(cutRope(100));
    }
    private int cutRope(int n) {
        if (n < 2)
            return 0;
        if (n==2)
            return 1;
        if (n==3)
            return 2;
        int timesOf3 = n / 3;
        if (n-3*timesOf3 ==1)
            timesOf3--;
        int timesOf2 = (n - 3 * timesOf3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
