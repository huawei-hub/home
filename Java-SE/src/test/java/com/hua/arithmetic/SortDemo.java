package com.hua.arithmetic;

import com.hua.util.Algorithm;
import org.junit.Test;

public class SortDemo {

    //1
    @Test
    public void test1(){
        int[] arr = {1, 3, 4, 4, 4, 6, 9, 11};
        System.out.println("判断数组中有没有："+Algorithm.find(arr,2));
        System.out.println("有序数组中找到第一个大于等于某个数的数："+Algorithm.nearLeftIndex(arr,5));
        System.out.println("有序数组中找到最后一个小于等于某个数的数："+Algorithm.nearRightIndex(arr,5));
        System.out.print("在排序数组中查找元素的第一个和最后一个位置：");
        for (int i : Algorithm.searchRange1(arr, 4)) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
