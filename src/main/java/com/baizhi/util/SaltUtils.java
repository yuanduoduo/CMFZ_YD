package com.baizhi.util;

import java.util.Random;

public class SaltUtils {

    public static void main(String[] args) {
        String salt = getSalt(4);
        System.out.println(salt);
    }

    public static String getSalt(Integer lenth) {
        String s = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenth; i++) {
            Random r = new Random();
            int d = r.nextInt(s.length());
            String ss = s.substring(d, d + 1);
            sb.append(ss);
        }
        return sb.toString();
    }
}
