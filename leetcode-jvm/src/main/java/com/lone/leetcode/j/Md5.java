package com.lone.leetcode.j;

import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author ljl133110
 * @date 2019/10/25
 */
public class Md5 {
    private static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String salt = "ruofan";

    public Md5() throws NoSuchAlgorithmException {
    }

    public static void main(String[] args) {
        System.out.println("http://h5.m.taobao.com/ww/index.htm#!dialog-" + Base64.getEncoder().encodeToString("阿里健康消费医疗".getBytes(StandardCharsets.UTF_8)));

        if(1==1) {
            return ;
        }
        char[] letters = new char[36];
        for (int i = 0; i < 10; i++) {
            letters[i] = (char) ('0' + i);
        }
        for (int i = 10; i < 36; i++) {
            letters[i] = (char) ('A' - 10 + i);
        }
        for (char l : letters) {
            System.out.println(l);
        }
        int len = 10;
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                for (int k = 0; k < letters.length; k++) {
                    String result = "" + letters[i] + letters[j] + letters[k];
                }
            }
        }
        System.out.println("妹找到");
    }

}
