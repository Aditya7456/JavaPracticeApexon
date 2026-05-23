package com.practice.graph;

import java.util.ArrayList;

public class Graph {
    public static ArrayList<ArrayList<Integer>> createGraph(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 7; // 1 based index 1-7
        for(int i=0; i<=V; i++){
            adj.add(new ArrayList<>());
        }
        // edge 1-2
        adj.get(1).add(2);
        adj.get(2).add(1);
        // edge 1-3
        adj.get(1).add(3);
        adj.get(3).add(1);
        // edge 2-5
        adj.get(2).add(5);
        adj.get(5).add(2);
        // edge 3-4
        adj.get(3).add(4);
        adj.get(4).add(3);
        // edge 3-6
        adj.get(3).add(6);
        adj.get(6).add(3);
        // edge 5-7
        adj.get(5).add(7);
        adj.get(7).add(5);
        // edge 6-7
        adj.get(6).add(7);
        adj.get(7).add(6);

        return adj;
    }
}
