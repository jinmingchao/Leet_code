package com.noctis.algorithms.test.easy.linked_list_cycle;

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
    public static boolean hasCycle(ListNode head) {
         ListNode current = head    ;
         Set<Integer> hashCodeSet = new HashSet<>();
         while (current != null){
             if(hashCodeSet.contains(current.hashCode())){
                 return true;
             }else {
                 hashCodeSet.add(current.hashCode());
             }
             current=current.next;
         }
            return false;
    }
    //2. two pointers: One pointer has much faster speed than another.
    //time complexity : O(n2)
    //space complexity : O(1)
    public static boolean _hasCycle(ListNode head) {
        ListNode fastPointer,slowPointer = head;
        try {
        fastPointer = head.next.next;
        slowPointer = head.next;
        }catch (NullPointerException npe){
            return false;
        }
        for (int i = 0;i<10000;i++){
            if(fastPointer==slowPointer){
                return true;
            }
            try {
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }catch (NullPointerException npe){
                return false;
            }

        }
                return false;
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

//        System.out.println(hasCycle(head));
        System.out.println(_hasCycle(head));
    }
}
