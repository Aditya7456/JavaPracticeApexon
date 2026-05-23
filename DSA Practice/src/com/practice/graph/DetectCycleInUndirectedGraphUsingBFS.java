package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraphUsingBFS {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = Graph.createGraph();
        int src = 1;
        int V = 7;
        boolean[] isVisited = new boolean[V+1];
        boolean isCycle = false;
        for(int i=1; i<=V; i++){
            if(!isVisited[i]){
                if(detectCycle(i,V,adj,isVisited)){
                   isCycle = true;
                    break;
                }
            }
        }
        System.out.println(isCycle ? "Cycle Detected!" : "Cycle not Detected!");
    }
    public static boolean detectCycle(int src, int V, ArrayList<ArrayList<Integer>> adj,boolean[] isVisited){
        isVisited[src] = true;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(src,-1));
        // traverse queue until it is empty
        while(!q.isEmpty()){
            Pair<Integer, Integer> pair = q.poll();
            for(int neighbor:adj.get(pair.first)){
                if(!isVisited[neighbor]){
                    isVisited[neighbor]=true;
                    q.add(new Pair<>(neighbor,pair.first));
                }
                else if(pair.second!=neighbor){
                    return true;
                }

            }
        }
        return false;
    }

}
