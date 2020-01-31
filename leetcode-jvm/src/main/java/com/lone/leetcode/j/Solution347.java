package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 思路: 首先肯定要把每个数出现的次数统计出来,能想到的就是用 map 维护,然后按出现次数排序.
 *
 * 1. 构建堆
 * 2. 自定义比较器,用 map 里的 value 来比价大小
 * 3. 桶?
 */
public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.compute(i, (key, v) -> v == null ? 0 : v + 1);
        }
        ArrayList[] sort = new ArrayList[nums.length];

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int val = entry.getValue();
            if (sort[val] == null) {
                sort[val] = new ArrayList();
            }
            sort[val].add(entry.getKey());
        }
        int idx = sort.length - 1;
        while (res.size() < k) {
            List list = sort[idx--];
            if(list != null) {
                res.addAll(list);
            }
        }
        return res.subList(0, k);
    }
}
