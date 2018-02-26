package com.qiwenchao.javademo.polymorphismdemo;

/**
 * @author chao
 * @Description {todo}
 * @date 2018/2/26 下午4:18
 * @todo:
 */
public class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    public String show(A obj) {
        return ("B and A");
    }
}
