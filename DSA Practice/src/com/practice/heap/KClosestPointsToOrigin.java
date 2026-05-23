package com.practice.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args){
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a,b)-> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        for(int i=0; i<points.length; i++){
            maxHeap.add(points[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()){
            res[i++]=maxHeap.poll();
        }
        System.out.println(Arrays.deepToString(res));
    }
}
