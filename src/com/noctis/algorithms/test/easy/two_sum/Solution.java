package com.noctis.algorithms.test.easy.two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Bob Jin
 * @Date 2020/2/16 5:02
 * @Description:
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Solution {

    public static void main(String[] args) {

          int[] input_array = new int[]{10,15,20,30,323,34,12,434,121};
          int target = 333;

          int[] result =twoSum_1(input_array,target);
//          int[] result = twoSum_2(input_array, target);
//            int[] result = twoSum_3(input_array, target);
          System.out.println("result :"+result[0]+", "+result[1]);
    }

    /**
     * Brute Force *
     * time complexity: O(n2);
     * space complexity: O(1);
     */
    public static int[] twoSum_1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length ; i++) {
           for(int j = 0;j < nums.length;j++){
               if(nums[i] + nums[j] == target && i!= j){
                   return new int[]{i,j};
               }
           }
        }
       throw new IllegalArgumentException("No pair can be found!");
    }

    /**
     * Two-pass Hash Table
     * time complexity: O(n);
     * space complexity: O(n);
     */
    public static int[] twoSum_2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> mapping = new HashMap<>();
        for (int i =0 ;i < nums.length ;i++) {
            mapping.put(nums[i],i);
        }

        for(int i =0;i< nums.length;i++){
            int complement = target - nums[i];
            if(mapping.containsKey(complement)&&mapping.get(complement)!=i){
                result[0] = i;
                result[1] = mapping.get(complement);
                return result;
            }
        }
        throw new IllegalArgumentException("No pair can be found!");

    }

    /**
     * One-pass Hash Table
     * time complexity: O(n);
     * space complexity: O(n);
     */
    public static int[] twoSum_3(int[] nums, int target) {
        Map<Integer,Integer> mapping = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
           int complement = target - nums[i];
           if(mapping.containsKey(complement)){
                return new int[]{i,mapping.get(complement)};
           }
            mapping.put(nums[i],i );
        }
        throw new IllegalArgumentException("No pair can be found!");
    }
}
