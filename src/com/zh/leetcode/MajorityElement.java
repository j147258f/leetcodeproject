package com.zh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 求众数
 */
public class MajorityElement {
    public static void main(String[] strs) {

    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i : nums) {
            Integer mapNum = count.get(i);
            if (mapNum != null) {
                count.put(i, mapNum + 1);
            } else {
                count.put(i, 1);
            }
        }

        int biggestCount = 0;
        int result = 0;
        for(Map.Entry<Integer,Integer> item :count.entrySet()){
            if(item.getValue()>biggestCount){
                biggestCount = item.getValue();
                result = item.getKey();
            }
        }
        return result;
    }
}
