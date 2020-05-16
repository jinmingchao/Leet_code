package com.noctis;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(1);
        l2.add(2);
        Set<List<Integer>> set = new HashSet<>();
        set.add(l1);
        set.add(l2);
        System.out.println("size of set: " + set.size());
        for (List<Integer> l:set) {
            for (Integer i :l) {
                System.out.println(i);
            }
        }
    }

    private static int[] twoSum_1(int[] input_array, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> m = new HashMap<>();
        for (int i =0;i<input_array.length;i++) {
            m.put(input_array[i],i);
        }
        for (Integer e:input_array) {
            if(m.containsKey(e)&&m.containsKey(target-e)){
                result[0] = m.get(e);
                result[1] = m.get(target-e);
                return result;
            }
        }


        return result;
    }
}
