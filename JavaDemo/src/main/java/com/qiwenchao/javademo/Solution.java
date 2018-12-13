package com.qiwenchao.javademo;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] sums=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    sums[0]=i;
                    sums[1]=j;
                    break;
                }
            }
        }
        System.out.println(sums[0]+","+sums[1]);
        return sums;
    }

     public static void main(String[] args){
         int[] nums={2,5,5,11};
         int target=10;
         twoSum(nums,target);
     }
}
