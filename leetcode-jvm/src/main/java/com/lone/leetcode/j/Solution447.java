package com.lone.leetcode.j;

/**
 *
 * https://leetcode.com/problems/number-of-boomerangs/
 * @author ljl133110
 * @date 2019-07-08
 */
public class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        int ret = 0;
        double[][] distance = new double[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length - 1; j++) {
                if (i == j) {
                    continue;
                }
                double toJ = calLength(points,i,j,distance);
                for(int k = j+1; k< points.length; k++) {
                    double tok = calLength(points, i, k,distance);
                    if (toJ == tok) {
                        ret+=2;
                    }
                }
            }
        }
        return ret;

    }

    private double calLength(int[][] points, int i, int j,double[][] distance) {
        if(distance[i][j] !=0) {
            return distance[i][j];
        }
        if (distance[j][i] != 0) {
            return distance[j][i];
        }
        double dis = Math.sqrt(Math.pow(points[j][0] - points[i][0],2) + Math.pow(points[j][1] - points[i][1],2));
        distance[i][j] = dis;
        distance[j][i] = dis;
        return dis;
    }

    public static void main(String[] args) {
        Solution447 solution447 = new Solution447();
        int[][] input = {{0,0},{1,0},{2,0}};
        System.out.println(solution447.numberOfBoomerangs(input));
    }
}
