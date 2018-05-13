package com.company;

/**
 * Created by zhanghao on 2018/5/13.
 */
public class SumInArrays {
    public static void main(String[] arge){
        int nums[]={3,2,4};
        twoSum(nums,6);
    }

        public static int[] twoSum(int[] nums, int target) {
            int answer[]={0,0};
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    if((nums[i]+nums[j])==target){
                        answer[0]=i;
                        answer[1]=j;
                        break;
                    }
                }
            }
            return answer;
        }
}
