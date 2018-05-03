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


        final ThreadLocal<Boolean> threadLocal=new ThreadLocal<Boolean>();
        threadLocal.set(true);
        System.out.println("main---"+threadLocal.get());

        new Thread("thread1"){
            @Override
            public void run() {
                super.run();
                threadLocal.set(false);
                System.out.println("thread1---"+threadLocal.get());
            }
        }.start();

        new Thread("thread2"){
            @Override
            public void run() {
                super.run();
                System.out.println("thread2---"+threadLocal.get());
            }
        }.start();

    }
}
