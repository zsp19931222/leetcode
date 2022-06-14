package com.zsp.leetcode;

import java.util.Random;

/**
 * @description: 反转链表
 * @author: created by zsp on 2022/6/10 0010 15:59
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1 = reverse(node1);
        while (node1 != null) {
            System.out.print(node1.value);
            node1 = node1.next;
        }
        System.out.println();

        MyQueue myQueue = new MyQueue();

        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        while (!myQueue.isEmpty()) {
            int poll = myQueue.poll();
            System.out.println(poll);
            System.out.println(myQueue.size);
            System.out.println("------------------");
        }
        System.out.println();
        MyStack myStack = new MyStack();
        myStack.offer(1);
        myStack.offer(2);
        myStack.offer(3);
        while (!myStack.isEmpty()) {
            int poll = myStack.poll();
            System.out.println("值=" + poll);
            System.out.println("长度=" + myStack.size);
            System.out.println("------------------");
        }

    }

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static class DoubleNode {
        int value;
        DoubleNode next;
        DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    private static Node reverse(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static DoubleNode reverseDouble(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * @description: 单链表实现队列
     * @author: zsp
     * @date: 2022/6/10 0010 16:44
     */
    private static class MyQueue {

        Node head = null;
        Node tail = null;
        int size = 0;

        public MyQueue() {
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offer(int v) {
            Node cur = new Node(v);
            if (tail == null) {
                head = cur;
            } else {
                //注意不要写成head.next=cur了
                tail.next = cur;
            }
            tail = cur;
            size++;
        }

        public int poll() {
            int result = -1;
            if (head != null) {
                result = head.value;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return result;
        }

    }

    /**
     * @description: 链表实现栈
     * @author: zsp
     * @date: 2022/6/10 0010 17:26
     */
    private static class MyStack {
        Node head;
        int size;

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offer(int v) {
            Node cur = new Node(v);
            if (head != null) {
                cur.next = head;
            }
            head = cur;
            size++;
        }

        public int poll() {
            int result = -1;
            if (head != null) {
                result = head.value;
                head = head.next;
                size--;
            }
            return result;
        }
    }

    /**
     * @description: 双端队列
     * @author: zsp
     * @date: 2022/6/10 0010 17:50
     */
    private static class MyDeque {
        DoubleNode head;
        DoubleNode tail;
        int size;

        public MyDeque() {
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offerHead(int v) {
            DoubleNode cur = new DoubleNode(v);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
            size++;
        }

        public void offerTail(int v) {
            DoubleNode cur = new DoubleNode(v);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail = cur;
            }
        }

        public int pollHead() {
            int result = -1;
            if (head == null) {
                return -1;
            }
            size--;
            result = head.value;
            if (head==tail){
                head=null;
                tail=null;
            }else {
                head=head.next;
                head.last=null;
            }
            return result;
        }
        public int pollTail() {
            int result = -1;
            if (head == null) {
                return -1;
            }
            size--;
            result = tail.value;
            if (head==tail){
                head=null;
                tail=null;
            }else {
                tail=tail.last;
                tail.next=null;
            }
            return result;
        }
    }
}
