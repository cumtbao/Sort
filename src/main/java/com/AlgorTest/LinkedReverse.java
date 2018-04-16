package com.AlgorTest;

/**
 * Created by liuzhixiong on 2018/4/14.
 */
public class LinkedReverse {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getDate() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        head = reverse1(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getDate() + " ");
            head = head.getNext();
        }
    }
    //递归
    public static Node reverse1(Node head){

        if(head==null || head.getNext() == null){
            return head;
        }

        Node reHead = reverse1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reHead;
    }



    static class Node{

        public Node(int date){
            this.date = date;
        }

        private int date;//数据域
        private Node next;//指针域

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
