package com.noctis.algorithms.test.medium._three_sum;

import java.util.*;

/**
 * @Author Bob Jin
 * @Date 2020/2/17 9:51
 * @Description: Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution {
    public static void main(String[] args) {
        int[] given_arr = new int[]{-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> result = three_sum_1(given_arr);
        List<List<Integer>> result = three_sum_2(given_arr);
        for (List<Integer> list:result) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }




    /**
     *
     * Brute Force
     * time complexity O(n3)
     * space complexity O(1)
     */

    private static List<List<Integer>> three_sum_1(int[] given_arr) {
        if (given_arr == null || given_arr.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(given_arr);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < given_arr.length; i++) {
            for (int j = i+1; j < given_arr.length; j++) {
                for (int k = j+1; k < given_arr.length; k++) {
                    if (given_arr[i] + given_arr[j] + given_arr[k] == 0) {
                        List<Integer> value = Arrays.asList(given_arr[i], given_arr[j], given_arr[k]);
                        result.add(value);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
    /**
     *
     * Two loop+one set
     * time complexity O(n2)
     * space complexity O(n)
     * out of time limitation
     */
    private static List<List<Integer>> three_sum_2(int[] given_arr) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < given_arr.length -1 ; i++) {
            Set<Integer> s = new LinkedHashSet<>(given_arr.length-i-1);
            for (int j = i+1; j < given_arr.length; j++) {
                   int target  = -(given_arr[i]+given_arr[j]);
                   if(s.contains(target)){
                       List<Integer> l=Arrays.asList(given_arr[i],given_arr[j],target);
                       l.sort(Comparator.naturalOrder());
                       result.add(l);
                   }else{
                       s.add(given_arr[j]);
                   }
            }
        }
        return new ArrayList(result);
    }

    /**
     * two-pointer
     */
    private static List<List<Integer>> three_sum_3(int[] given_arr) {
        int p_1 = -1;
        int p_2 = -1;
        int mark = 0;
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < given_arr.length-2; i++) {
            p_1 = i+1;
            p_2 = given_arr.length-1;
            while (true){
                if(p_1!=p_2){
                    if(0 == given_arr[i] + given_arr[p_1] + given_arr[p_2]){
                        mark = 0;
                        List<Integer> r = new LinkedList<>();
                        r.add(given_arr[i]);
                        r.add(given_arr[p_1]);
                        r.add(given_arr[p_2]);
                        result.add(r);
                        break;
                    }

                    if(mark == 0){
                        p_1++;
                        mark = 1;
                    }else{
                        p_2--;
                        mark = 0;
                    }
                }else{
                    mark = 0;
                    break;
                }
            }
        }
        return result;
    }
}
