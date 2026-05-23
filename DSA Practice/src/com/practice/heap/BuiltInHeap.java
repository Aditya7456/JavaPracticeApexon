package com.practice.heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BuiltInHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // minHeap
        Comparator<Integer> comparator = new Comparator<>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);
        maxHeap.addAll(List.of(8,1,3,2,-5,9,0));
        System.out.println(maxHeap);

    }
}
