package com.lone.leetcode.j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * 思路: 依然是拓扑排序
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        Map<Integer, Set<Integer>> adjacent = new HashMap<>(numCourses*2);
        for (int[] pre : prerequisites) {
            degrees[pre[0]] ++;
            adjacent.computeIfAbsent(pre[1], k -> new HashSet<>());
            adjacent.get(pre[1]).add(pre[0]);
        }
        int[] ret = new int[numCourses];
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(degrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            ret[idx++] = course;
            Set<Integer> set = adjacent.get(course);
            if (set == null) {
                continue;
            }
            for (int c : set) {
                degrees[c]--;
                if(degrees[c] == 0) {
                    queue.offer(c);
                }
            }
        }
        return idx == ret.length ? ret : new int[]{};
    }
}
