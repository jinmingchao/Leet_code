package com.noctis.algorithms.test.easy.reverse_linked_list;

import java.util.LinkedList;

/**
 * @Author MingChao Jin
 * @Date 2020/5/10 22:01
 * @Description: https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Solution {
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //Use linked list
    //time complexity : O(n)
    //space complexity ? O(n)
    public static ListNode reverseList(ListNode head) {
        if(head ==null){
            return null;
        }
        LinkedList<ListNode> nodes = new LinkedList<>();
        nodes.add(head);

        while (head.next!=null) {
            head = head.next;
            nodes.add(head);
        }
        nodes.get(0).next =null;
        for (int i = 0; i < nodes.size()-1; i++) {
            nodes.get(i+1).next = nodes.get(i);
        }
        return nodes.pollLast();
    }

    //Use For loop(same as method 1)
    //time complexity : O(n)
    //space complexity ? O(1)
    public static ListNode reverseList_(ListNode head) {
        if(head ==null){
            return null;
        }
        ListNode pre =null;
        ListNode current = head;
        while (current!=null){
            ListNode next =current.next;
            current.next= pre;
            pre = current;
            current = next;
        }
        return pre;
    }

//    public static ListNode reverseList__(ListNode head) {
//        if(head ==null){
//            return null;
//        }
//        if(head.next==null){
//            return head;
//        }else{
//            reverseList__()
//        }
//        ListNode pre =null;
//        ListNode current = head;
//        while (current!=null){
//            ListNode next =current.next;
//            current.next= pre;
//            pre = current;
//            current = next;
//        }
//        return pre;
//    }

    public static void main(String[] args) {
        // 1->2->3->4->5->null
        ListNode head= new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode _head = reverseList_(head);
        while (_head !=null){
            System.out.print(_head.val+"->");
            _head = _head.next;
        }
    }
}
