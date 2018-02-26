package com.qiwenchao.javademo.polymorphismdemo;

/**
 * @author chao
 * @Description {todo}
 * @date 2018/2/26 下午4:17
 * @todo:
 */
public class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }
}
