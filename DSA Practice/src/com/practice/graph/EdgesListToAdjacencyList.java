package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdgesListToAdjacencyList {
    public static void main(String[] args){
        int[][] edges = {
                {0, 1},
                {0, 3},
                {1, 2},
                {2, 3}
        };
//        List<List<Integer>> adjList = new ArrayList<>();
//        // let's initialize the adjList
//        for(int i=0; i<4; i++){
//            adjList.add(new ArrayList<>());
//        }
//        for(int i=0; i<edges.length; i++){
//            adjList.get(edges[i][0]).add(edges[i][1]);
//        }
//        System.out.println(adjList);

        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            // we need to create list if not present
            adj.putIfAbsent(u,new ArrayList<>());
            adj.putIfAbsent(v,new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(adj);
    }
}
