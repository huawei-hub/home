package com.hua.算法;

public class 数组中重复的数字 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 5, 5};

        System.out.println(duplicate(arr));

    }
    public static int duplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return  nums[i];
                }
                swap(nums, i, nums[i]);
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
