package com.lone.leetcode.n;

/**
 * @author ljl133110
 * @date 2020-05-12
 */
public class CompareTwoNumber {

    public int getMax(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return scA * a + scB * b;
    }

    public int flip(int n) {
        return n ^ 1;
    }

    public int sign(int n) {
        return flip(n >> 31) & 1;
    }

    /**
     * 不会溢出
     *
     * 如果 a b 符号相同,肯定不会溢出 (difSab = 0 sameSab = 1)
     * a - b 为正就返回 a(sc = 1),
     * a- b 为负就返回 b (sc = 0)
     *
     *
     *
     * 如果 a b 符号不同(difSab = 1 sameSab = 0)
     *
     * 如果 a 为 0 或正  返回 a   (sa = 1 sb = 0)
     * 如果 b 为 0 或正  返回 b  (sa = 0 sb = 1)
     *  a*(difSab*sa + sameSab*sc)
     */
    public int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab *sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }



    public static void main(String[] args) {
        CompareTwoNumber compare = new CompareTwoNumber();
        System.out.println(compare.getMax(1111, 221));
        System.out.println(compare.getMax(1111, 2221));
        System.out.println(compare.getMax(-1111, 2221));
    }
}
