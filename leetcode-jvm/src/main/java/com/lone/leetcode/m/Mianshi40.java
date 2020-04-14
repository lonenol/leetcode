//package com.lone.leetcode.m;
//
///**
// * @author ljl133110
// * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
// *
// * 思路: 就是topK
// * 1. 排序 ,取前 k 个
// * 2. partition
// */
//public class Mianshi40 {
//
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if(arr.length == 0 || k == 0) {
//            return new int[]{};
//        }
//        int cur = 0;
//        while (cur != k) {
//            cur = partition(arr,0,arr.length);
//        }
//
//    }
//
//    private int partition(int[] arr, int start, int end) {
//        int base = arr[start];
//        int left = start + 1, right = end;
//        while (left < right) {
//            while (arr[left] < base) {
//                left++;
//            }
//            while (arr[right] > base) {
//                right--;
//            }
//            if (left >= right) {
//                break;
//            }
//            swap(arr, left, right--);
//        }
//        swap(arr,base,right);
//        return right;
//    }
//
//    private void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }
//}
