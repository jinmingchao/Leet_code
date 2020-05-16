package com.noctis.algorithms.test.hard.reverse_nodes_in_k_group;

/**
 * @Author MingChao Jin
 * @Date 2020/5/15 9:17
 * @Description: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode pre = null;
        ListNode start = head;
        while (current!=null) {
            for (int i = 0; i < k; i++) {
                if (null != current) {

                }else{
                    return head;
                }
                current = current.next;
            }

           for (int i =0;i<k;i++){
                ListNode next=start.next;
                start.next = pre;
                next.next = start;
                pre = start;
                start = next;
            }
        }
             return head;
    }
    
    public static void main(String[] args) {
        // 1->2->3->4->5->null
        int k = 2;
        ListNode head= new  ListNode(1);
        head.next = new  ListNode(2);
        head.next.next = new  ListNode(3);
        head.next.next.next = new  ListNode(4);
        head.next.next.next.next = new  ListNode(5);
        ListNode _head = reverseKGroup(head,k);
        while (_head !=null){
            System.out.print(_head.val+"->");
            _head = _head.next;
        }
    }
}
