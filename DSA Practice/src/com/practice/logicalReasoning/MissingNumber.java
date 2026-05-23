package com.practice.logicalReasoning;

public class MissingNumber {
    public static void main(String[] args){
        int[] nums = {3,0,1};
        System.out.println(findMissingNumber(nums));
    }
    public static int findMissingNumber(int[] nums){
          // xor method
//        int xor = 0;
//        for(int i=0; i<=nums.length; i++) xor^=i;
//        for(int num:nums) xor^=num;
//        return xor;

        // using normal math reasoning with Arithmetic Progression
        int n = nums.length;
        int expectedSum = n * (n+1)/2;
        int actualSum = 0;
        for(int num:nums) actualSum+=num;
        return expectedSum - actualSum;
    }
}
