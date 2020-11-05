package com.zh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 136给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumber {
    public static void main(String[] agrs) {

    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index == null) {
                map.put(nums[i],nums[i]);
            }else{
                map.remove(nums[i]);
            }
        }


        return map.keySet().iterator().next();
    }
}
