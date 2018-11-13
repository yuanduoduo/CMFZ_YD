package com.baizhi.test;

import org.junit.Test;

import java.util.UUID;

public class test1 {
    @Test
    public void main() {
        String s = UUID.randomUUID().toString();
        int length = s.length();
        System.out.println(length);
    }
}
