package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnection {
    public static void main(String[] args){
        int[][] edges = {
                {1,2},
                {1,3},
                {2,3}
        };
        boolean[] isVisited = new boolean[edges.length+1];
        for(int[] edge: edges){
            if(!isVisited[edge[1]]){
                dfs(edges,edge,isVisited);
            }
        }
    }
    public static void dfs(int[][] edges, int[] edge,boolean[] isVisited){

    }
}
