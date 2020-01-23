package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 思路:
 * 二分搜索,感觉上容易实现的是先找到在哪一行,然后去这一行里搜
 * 感觉也可以直接转换坐标,就和传统的二分查找没有任何区别
 * x = mid /n
 * y = mid % n
 *
 * ps: 看来 case 里没有 m*n 溢出int的情况..不过这里是一个注意点
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length,n = matrix[0].length, left = 0, right = m*n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x = mid /n;
            int y = mid % n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
