package com.qiwenchao.javademo;

import java.util.ArrayList;

class Solution1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s1=resvertInt(l1);
        int s2=resvertInt(l2);
        int s3=s1+s2;
        return insert(s3);
    }

    public static ListNode insert(int data) {
        ListNode node=null;
        if (node == null) {
            node = new ListNode(data);
            return node;
        }
        ListNode cur = node;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(data);
        return cur;
    }

    public static int resvertInt(ListNode l){
        ListNode cur=l;
        ArrayList<Integer> list=new ArrayList();
        do {
            list.add(cur.val);
            cur=cur.next;
        }while(cur.next!=null);
        int lN1=0;
        for(int i=0;i<list.size();i++){
            lN1+=list.get(i)*Math.pow(10,i);
        }
        return lN1;
    }

    static ListNode head, tail;
    public static void main(String[] args){
//        ListNode l1=new ListNode(2);
//        l1.next=new ListNode(4);
//        l1.next.next=new ListNode(3);
//        l1.next.next.next=new ListNode(0);
//        ListNode l2=new ListNode(5);
//        l2.next=new ListNode(6);
//        l2.next.next=new ListNode(4);
//        l2.next.next.next=new ListNode(0);
//
//        ListNode listNode = addTwoNumbers(l1, l2);
//        System.out.print(listNode);
        create(2);
        create(4);
        create(3);
        ListNode tmp = head;
        while(tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public static ListNode create(int val) {
        ListNode n = new ListNode(val);
        if(head == null) {
            head = n;
            tail = head;
        } else {
            tail.next = n;
        }
        tail = n;
        return n;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}