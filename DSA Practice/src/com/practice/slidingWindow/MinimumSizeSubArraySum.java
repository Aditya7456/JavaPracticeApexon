package com.practice.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int count = 0;
        for(int num:nums){
            prefixSum+=num;
            if(map.containsKey(prefixSum-target)){ // if map already has this sum
                count+=map.get(prefixSum-target);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        System.out.println(count);
    }
}
