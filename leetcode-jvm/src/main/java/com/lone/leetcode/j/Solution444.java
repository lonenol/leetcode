package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/sequence-reconstruction/
 * 思路: 拓扑排序,这道题需要注意的是 segs 里有很多非法输入...
 */
public class Solution444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(org.length == 0 || seqs.isEmpty()) {
            return false;
        }
        int[] degrees = new int[org.length];
        Set<Integer> nums = new HashSet<>();
        Map<Integer, Set<Integer>> adjacentMap = new HashMap<>(org.length * 2);
        for (List<Integer> seg : seqs) {
            nums.addAll(seg);
            if(seg.size() == 1) {
                adjacentMap.computeIfAbsent(seg.get(seg.size() - 1), k->new HashSet<>());
            }
            for (int i = 0; i < seg.size() - 1; i++) {
                adjacentMap.computeIfAbsent(seg.get(i), k -> new HashSet<>());
                if(!adjacentMap.get(seg.get(i)).contains(seg.get(i + 1))) {
                    if(seg.get(i+1) -1 < degrees.length && seg.get(i+1) -1 >=0) {
                        degrees[seg.get(i+1)-1]++;
                    }
                    adjacentMap.get(seg.get(i)).add(seg.get(i + 1));
                }

            }
        }
        if (adjacentMap.isEmpty() || nums.size() < org.length || nums.size() > org.length) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if(degrees[i] == 0) {
                queue.offer(i+1);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            if(queue.size() > 1) {
                return false;
            }
            int cur = queue.poll();
            if (org[idx++] != cur) {
                return false;
            }
            Set<Integer> set = adjacentMap.get(cur);
            if (set == null) {
                continue;
            }
            for (int s : set) {
                degrees[s-1]--;
                if (degrees[s-1] == 0) {
                    queue.offer(s);
                }
            }
        }
        return idx == org.length;
    }

    public static void main(String[] args) {
        Solution444 solution444 = new Solution444();
        int[] org = {1,2};
        List<List<Integer>> segs = new ArrayList<>();
        segs.add(new ArrayList<>());
        segs.add(Arrays.asList(1, 2));
        segs.add(Arrays.asList(1, 2));
        //segs.add(Arrays.asList(1, 3));
        //segs.add(Arrays.asList(2, 3));
        System.out.println(solution444.sequenceReconstruction(org, segs));
    }
}
