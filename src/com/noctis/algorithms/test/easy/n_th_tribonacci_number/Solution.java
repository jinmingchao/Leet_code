package com.noctis.algorithms.test.easy.n_th_tribonacci_number;

/**
 * @Author MingChao Jin
 * @Date 2020/5/16 12:12
 * @Description: https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
public class Solution {

    // 1. recursion
    public static int tribonacci(int n) {
      if (0 == n) {
          return 0;
      }

      if (1 == n || 2 == n) {
          return 1;
      }
       return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }

    //2. straight forward
    //tc: O(n)
    //sc: O(1)
    public static int tribonacci_(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 1, d;
        while (n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(38));

    }
}
