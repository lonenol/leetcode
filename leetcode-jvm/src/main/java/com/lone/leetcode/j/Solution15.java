package com.lone.leetcode.j;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * 思路：
 * 1. 暴力三重循环
 * 2. 数组全放到map里，然后两重循环，第三个数在map里找,注意map的key是值，value是索引，用来处理 0 0 0 4 -2 这种case，时间O（n^2），空间O(n),这个要处理重复的问题,最后大case的时候超时了。。
 * 3. sort and find ,网上找吧。。全是这种解法时间O（n^2），空间O(1)，这个解法可以剪枝提高效率，还自带去重,但是需要一次排序
 * 比第二种好很多，就是思路没那么自然。
 *
 */
public class Solution15 {


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length-2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum =nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[++j]);
                    while(k > j && nums[k] == nums[--k]);
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }


        }
        return res;
    }


        public List<List<Integer>> threeSum_map(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            put(map,i);
        }
        Set<List<Integer>> tmpRes = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                remove(map,nums[i]);
                remove(map,nums[j]);
                int third = -nums[i] - nums[j];
                if(map.get(third) != null) {
                    List<Integer> tmp =Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(tmp);
                    tmpRes.add(tmp);
                }
                put(map,nums[i]);
                put(map,nums[j]);

            }
        }
        return new ArrayList<>(tmpRes);
    }

    private void put(Map<Integer, Integer> map, Integer key) {
        Integer val = map.get(key);
        map.put(key, val == null ? 1 : ++val);
    }

    private void remove(Map<Integer, Integer> map, Integer key) {
        Integer val = map.get(key);
        map.put(key, val == 1 ? null : --val);
    }


    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        solution15.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println();
    }
}