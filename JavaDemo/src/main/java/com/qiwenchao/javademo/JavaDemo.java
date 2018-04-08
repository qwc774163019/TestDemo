package com.qiwenchao.javademo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class JavaDemo {
    public static void main(String[] args){
//        System.out.println("hello world");
//        Person person=new Student();
//        person.eat();

        String s = "zhaoxiaofnag%40eims.com.cn ";
        try {
            s= URLDecoder.decode(s,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s);

        String china = "%31%32%36%2E%61%6D/hEeGv4";
        try {
            china = URLDecoder.decode(china,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(china);
    }
}
