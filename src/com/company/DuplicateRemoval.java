package com.company;

/**
 * 数组去重
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class DuplicateRemoval {

    public static void main(String[] args) {
	int nums[]={1,1,2};
	int i=removeDuplicates(nums);
    System.out.println(i);

    for(int a=0;a<i;a++) System.out.println(nums[a]);

    }

    public static int removeDuplicates(int[] nums) {
        int startindex=0;
        int endindex=nums.length-1;
        for(int i =1;i<nums.length;i++){
            if(i==endindex) break;
            if(nums[startindex] == nums[i])
            {
                int temp=nums[nums.length-1];
                nums[nums.length-1]=nums[i];
                nums[i]=temp;
                startindex++;
                endindex--;
            }
        }
        return endindex;
    }
}
