package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * 以每个字符为中心向两边查,需要考虑基数和偶数
 *
 * @author liujinlong
 * @date 2018/9/18
 */
public class Solution5 {

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        String maxStr = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            String odd = calOddLongest(s, i);
            String even = calEvenLongest(s, i);
            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }
        return maxStr;
    }

    public String calOddLongest(String s, int mid) {
        return calLongest(s, mid , mid);

    }

    public String calEvenLongest(String s, int mid) {
        String max = "";
        if((mid - 1) >= 0 && s.charAt(mid) == s.charAt(mid -1)) {
            String lLong = calLongest(s, mid - 1, mid);
            max = lLong;
        }
        if(mid+1 < s.length() && s.charAt(mid) == s.charAt(mid +1)) {
            String rLong = calLongest(s, mid, mid + 1);
            if (rLong.length() > max.length()) {
                max = rLong;
            }
        }
        return max;

    }

    /**
     * 调用的地方保证不越界
     * @param s
     * @param lMid 偶数回文左起始点
     * @param rMid 偶数回文右起始点
     * @return
     */
    public String calLongest(String s, int lMid,int rMid) {
        int i = 0;
        while ((lMid - i) >= 0 && (rMid + i) < s.length()) {
            if (s.charAt(lMid - i) != s.charAt(rMid + i)) {
                break;
            }
            i++;
        }
        //最后一次的i++得到的是一个非法的i,减掉.
        i--;
        return s.substring(lMid - i, rMid + i + 1);
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("bb"));
        System.out.println(solution5.longestPalindrome("cbbd"));
        System.out.println(solution5.longestPalindrome("babad"));
    }
}
