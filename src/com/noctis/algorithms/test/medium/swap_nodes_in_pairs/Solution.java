package com.noctis.algorithms.test.medium.swap_nodes_in_pairs;

import java.util.List;

/**
 * @Author MingChao Jin
 * @Date 2020/5/13 19:48
 * @Description: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Solution {
    // Definition for singly-linked list.
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    //1. Iteration
    //time complexity : O(n)
    //space complexity : O(1)
    public static ListNode swapPairs(ListNode head) {
        ListNode fakeNode= new ListNode(-1);
        ListNode pre = fakeNode;
        fakeNode.next = head;

         while (pre.next!=null && pre.next.next!=null){
             ListNode firstNode = pre.next;
             ListNode secondNode = pre.next.next;

             pre.next = secondNode;
             firstNode.next = secondNode.next;
             secondNode.next = firstNode;

             pre = firstNode;

         }
        return fakeNode.next;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->null
        ListNode head= new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode _head = swapPairs(head);
        while (_head !=null){
            System.out.print(_head.val+"->");
            _head = _head.next;
        }
    }
}
