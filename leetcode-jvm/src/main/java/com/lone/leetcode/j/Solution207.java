package com.lone.leetcode.j;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 * 思路:拓扑排序
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        HashSet[] adjacent = new HashSet[numCourses];
        for (int[] pre : prerequisites) {
            if(adjacent[pre[1]] == null) {
                adjacent[pre[1]] = new HashSet();
            }
            adjacent[pre[1]].add(pre[0]);
            degrees[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                HashSet<Integer> set = adjacent[cur];
                if (set == null) {
                    continue;
                }
                for (Integer cou : set) {
                    degrees[cou]--;
                    if(degrees[cou] == 0) {
                        queue.offer(cou);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        int[][] prerequisites = {{0, 1}};
        System.out.println(solution207.canFinish(2, prerequisites));
    }
}
