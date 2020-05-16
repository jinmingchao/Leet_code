package com.noctis.algorithms.test.medium.add_two_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Bob Jin
 * @Date 2020/2/18 7:41
 * @Description:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Solution {

    public static void main(String[] args) {
        // (2 -> 4 -> 3)
//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;

        // (5 -> 6 -> 4)
//        ListNode _l1 = new ListNode(5);
//        ListNode _l2 = new ListNode(6);
//        ListNode _l3 = new ListNode(4);
//        _l1.next = _l2;
//        _l2.next = _l3;

        ListNode l1 = new ListNode(0);
        ListNode _l1 = new ListNode(1);
        ListNode sum =addTwoNumbers(l1,_l1);
        List<Integer> list = new ArrayList<>();
        while (sum != null){
            list.add(sum.val);
            if(sum.next !=null){
                sum = sum.next;
            }else{
                sum = null;
            }
        }
//        list.add(sum.val);
//        sum = sum.next;
//        list.add(sum.val);
//        sum = sum.next;
//        list.add(sum.val);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer _num_1 = 0,_num_2 = 0;
        ListNode ones = new ListNode(0);
        ListNode tens = new ListNode(0);
        ListNode hundreds = new ListNode(0);
        ones.next = tens;
        tens.next = hundreds;

        // Get the number from the ListNode.
        for (int i = 0; 3 > i; i++) {
            if(l1 != null) {
                _num_1 += l1.val * (int) Math.pow(10, i);
                if(null != l1.next) {
                    l1 = l1.next;
                }else{
                    l1 = null;
                }
            }
            if(l2 != null) {
                _num_2 += l2.val * (int) Math.pow(10, i);
                if(null != l2.next){
                    l2 = l2.next;
                }else{
                    l2 = null;
                }
            }



        }
        // Sum two numbers.
        int then = _num_1 + _num_2;

        // Store all digits into a array
        Integer[] result_num = new Integer[3];
        for (int i = 2; i > -1; i--) {
            if(then / (int)Math.pow(10, i) > 0){ // There are i digits in this number.
               int digit = then / (int)Math.pow(10, i);
               result_num[i] = digit;
               then = then % (int)Math.pow(10, i);
            }
        }

        for (int i = 0; i < result_num.length; i++) {
            if(null != result_num[i]){
                
                  switch (i){
                      case 0:ones.val = result_num[i];break;
                      case 1:tens.val = result_num[i];break;
                      case 2:hundreds.val = result_num[i];break;
                  }
            }
        }

        if( 0 == tens.val && 0 == hundreds.val){
            ones.next = null;
        }
        if(0 == hundreds.val){
            tens.next = null;
        }

        return ones;
    }

    /**
     *  Definition for singly-linked list.
     */
     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x;}
     }

}
