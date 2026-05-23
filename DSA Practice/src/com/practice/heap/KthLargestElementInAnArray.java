package com.practice.heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args){
        int[] arr = {3,2,1,5,6,4};
        int k = 3;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(6);
        for(int num:arr){
            minHeap.add(num);
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
        System.out.println(minHeap.peek());
    }
}
