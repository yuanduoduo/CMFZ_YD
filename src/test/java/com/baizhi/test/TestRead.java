package com.baizhi.test;

import com.baizhi.util.ReadMp3;
import org.junit.Test;

public class TestRead {
    @Test
    public void test1() {
        String read = ReadMp3.read("/Users/yuanduo/ideacode/CMFZ_YD/target/CMFZ_YD/"+"cmfz/chapter/周杰伦 - 七里香.mp3");
        System.out.println(read);
    }

    @Test
    public void tset2() {
        try {
            Thread.currentThread().sleep(5000);
            String size = ReadMp3.size("/Users/yuanduo/ideacode/CMFZ_YD/target/CMFZ_YD/" + "cmfz/chapter/周杰伦 - 七里香.mp3");
            System.out.println(size);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        String read = ReadMp3.size("/Users/yuanduo/ideacode/CMFZ_YD/target/CMFZ_YD/" + "cmfz/chapter/周杰伦 - 七里香.mp3");
        System.out.println(read);
    }
}
