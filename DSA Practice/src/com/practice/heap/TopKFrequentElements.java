package com.practice.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a,b) -> map.get(a) - map.get(b));
        for(int num:map.keySet()){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        for(int num:minHeap){
            res[i++]=num;
        }
        System.out.println(Arrays.toString(res));
    }
}



// return Arrays.stream(nums)
//         .boxed()
//         .collect(Collectors.groupingBy(
//             Function.identity(),
//             LinkedHashMap::new,
//             Collectors.counting()
//         ))
//         .entrySet()
//         .stream()
//         .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
//         .limit(k)
//         .map((entry)->entry.getKey())
//         .mapToInt(Integer::intValue)
//         .toArray();
