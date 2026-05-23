package com.practice.dsa;
// Leetcode 3693
public class ClimbingStairs2 {
    public static void main(String[] args) {
        int[] costs = {1,2,3,4};
        System.out.println(climbStairs(costs.length,costs));
    }
    public static int climbStairs(int n, int[] costs){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            dp[i] = Integer.MAX_VALUE;
            // if i-1 exists then we will calculate the jump cost from i-1 to i
            if(i-1>=0){
                dp[i] = Math.min(dp[i],dp[i-1] + costs[i-1] + 1);
            }
            // if i-2 exists then we will calculate the jump cost from i-2 to i
            if(i-2>=0){
                dp[i] = Math.min(dp[i],dp[i-2] + costs[i-1] + 4);
            }
            if(i-3>=0){
                dp[i] = Math.min(dp[i],dp[i-3] + costs[i-1] + 9);
            }
        }
        return dp[n];
    }
}
