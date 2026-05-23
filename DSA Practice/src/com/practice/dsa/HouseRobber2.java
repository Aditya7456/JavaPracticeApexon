package com.practice.dsa;

import java.util.Arrays;

// Leetcode 213
public class HouseRobber2 {
    public static void main(String[] args){
        int[] nums = {2,7,3,1,4,2,1,8};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
        int n = nums.length;
        if(n<2) return nums[0];
        // let's create two array
        int[] skipLastHouse = new int[n-1];
        int[] skipFirstHouse = new int[n-1];

        // fill skipLastHouse (0 → n-2)
        for (int i = 0; i < n - 1; i++) {
            skipLastHouse[i] = nums[i];
        }

        // fill skipFirstHouse (1 → n-1)
        for (int i = 1; i < n; i++) {
            skipFirstHouse[i - 1] = nums[i];
        }
        return Math.max(HouseRobber1.rob(skipLastHouse),HouseRobber1.rob(skipFirstHouse));
    }
}
