package com.hua.se.util;

public class Algorithm {

    //在排序数组中某个数是否存在
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + right;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    //在有序数组中找到第一个大于等于某个数的数
    public static int nearLeftIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length;
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    //有序数组中找到最后一个小于等于某个数的数
    public static int nearRightIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length;
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] <= num) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    //在排序数组中查找元素的第一个和最后一个位置
    //1 一次二分查找 + 遍历
    public static int[] searchRange1(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                left = mid;
                right = mid;
                while (left > 0 && target == nums[left - 1]) {
                    left--;
                }
                while (right < nums.length && target == nums[right+1]) {
                    right++;
                }
                return new int[]{left, right};
            }
        }
        return new int[]{-1,-1};
    }

    //在排序数组中查找元素的第一个和最后一个位置
    //2 一次二分查找 + 遍历
    public int[] searchRange2(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = arr.length;
        return new int[]{-1, -1};
    }
}
