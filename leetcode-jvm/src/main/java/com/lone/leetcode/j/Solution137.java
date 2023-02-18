package com.lone.leetcode.j;

/**
 * @author ljl133110
 * @date 2020-05-13
 */
public class Solution137 {

    public int singleNumber(int[] nums) {
        return singleNumberK(nums, 3);
    }

    public int singleNumberK(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            ans = ans | ((sum % k) << i);
        }
        return ans;
    }


        public int singleNumber_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return onceNum(nums, 3);
    }

    public static int onceNum(int[] arr, int k) {
        int[] eO = new int[32];
        for (int i = 0; i != arr.length; i++) {
            setExclusiveOr(eO, arr[i], k);
        }
        int res = getNumFromKSysNum(eO, k);
        return res;
    }

    public static void setExclusiveOr(int[] eO, int value, int k) {
        int[] curKSysNum = getKSysNumFromNum(value, k);
        for (int i = 0; i != eO.length; i++) {
            eO[i] = (eO[i] + curKSysNum[i]) % k;
        }
    }

    public static int[] getKSysNumFromNum(int value, int k) {
        int[] res = new int[32];
        int index = 0;
        while (value != 0) {
            res[index++] = value % k;
            value = value / k;
        }
        return res;
    }

    public static int getNumFromKSysNum(int[] eO, int k) {
        int res = 0;
        for (int i = eO.length - 1; i != -1; i--) {
            res = res * k + eO[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-401451, -177656, -2147483646, -473874, -814645, -2147483646, -852036, -457533, -401451, -473874,
            -401451, -216555, -917279, -457533, -852036, -457533, -177656, -2147483646, -177656, -917279, -473874,
            -852036, -917279, -216555, -814645, 2147483645, 2147483645, -814645, 2147483645, -216555,-2147483648};
        Solution137 solution137 = new Solution137();
        int[] test = solution137.getKSysNumFromNum(-2147483648, 3);
        System.out.println(solution137.singleNumber(arr));
        System.out.println(solution137.getNumFromKSysNum(test, 3));
        //System.out.println(solution137.getNumFromKSysNum(solution137.getKSysNumFromNum(-2147483648,3),3));

    }
}
