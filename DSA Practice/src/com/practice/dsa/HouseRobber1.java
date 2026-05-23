package com.practice.dsa;

public class HouseRobber1 {
    public static void main(String[] args){
        int[] nums = {2,7,3,1,4,2,1,8};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
        // if there is only one element returning that element
        if(nums.length == 1) return nums[0];
        // else creating a dp array to store the loot for every index;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        // using them to filling the complete dp array
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
