package com.noctis.algorithms.test.medium.linked_list_cycle_ii;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author MingChao Jin
 * @Date 2020/5/14 18:38
 * @Description: https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class Solution {

    public static class ListNode {
        int val;
         ListNode next;
        ListNode(int x) { val = x; }
    }

    //1. (HashMap)Use set to store the address of each listNodes.
    //time complexity : O(n)
    //space complexity : O(n)
    public static ListNode detectCycle(ListNode head) {
         ListNode current = head;
         Set<ListNode> listNodeSet = new HashSet<>();
         while (current != null){
             if(listNodeSet.contains(current)){
                 return current;
             }else {
                 listNodeSet.add(current);
             }
             current=current.next;
         }
            return null;
    }

    //2. Floyd
    //time complexity :
    //space complexity :
    public static ListNode detectCycle_(ListNode head) {

                return null;
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->null
        ListNode head= new ListNode(1);
        head.next = new  ListNode(2);
        ListNode L=new  ListNode(3);
        head.next.next = L;
        head.next.next.next = new  ListNode(4);
        head.next.next.next.next = new  ListNode(5);
        head.next.next.next.next = L;

      //  System.out.println(detectCycle(head));
          System.out.println(detectCycle_(head));
    }
}
