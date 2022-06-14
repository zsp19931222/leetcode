package com.zsp.leetcode;

/**
 * @description: 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: created by zsp on 2022/6/7 0007 11:49
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(6);
        ListNode node = addTwoNumbers(node1, node2);
        System.out.println(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;

        int lenL = nodeLen(l1);
        int lenS = nodeLen(l2);
        //找到最长的链表与最短链表
        ListNode l;
        ListNode s;
        if (lenL >= lenS) {
            l = l1;
            s = l2;
        } else {
            l = l2;
            s = l1;
        }
        //当前最长/短链表的节点
        ListNode curL = l;
        ListNode curS = s;
        int carry = 0;
        int num = 0;
        int val = 0;
        while (curS != null) {
            num = curL.val + curS.val + carry;
            //获取进位数
            carry = (num / 10);
            //获取节点值
            val = num % 10;
            ListNode curNode = new ListNode(val);
            if (head == null) {
                head = curNode;
            } else {
                tail.next = curNode;
            }
            tail = curNode;
            curL = curL.next;
            curS = curS.next;
        }
        //长链表还有值
        while (curL != null) {
            num = curL.val  + carry;
            //获取进位数
            carry = (num / 10);
            //获取节点值
            val = num % 10;
            ListNode curNode = new ListNode(val);
            tail.next = curNode;
            tail = curNode;
            curL = curL.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    private static int nodeLen(ListNode node) {
        int len = 0;

        while (node.next != null) {
            len++;
            node = node.next;
        }
        return len;
    }


    private static void newNode(ListNode head,ListNode tail,int v){
        ListNode curNode = new ListNode(v);
        if (head == null) {
            head = curNode;
        } else {
            tail.next = curNode;
        }
        tail = curNode;
    }
}
