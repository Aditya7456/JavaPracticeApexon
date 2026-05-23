package com.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsInGraph {
    public static void main(String [] args){
        int v = 6; // 0 to 5
        int source = 0, destination = 5;
        List<List<Integer>> graph = new ArrayList<>();
        // initialize the list in graph
        for(int i=0; i<6; i++){
            graph.add(new ArrayList<>());
        }
        // 0-1
        graph.get(0).add(1);
        graph.get(1).add(0);
        // 0-2
        graph.get(0).add(2);
        graph.get(2).add(0);
        //1-4
        graph.get(1).add(4);
        graph.get(4).add(1);
        //2-3
        graph.get(2).add(3);
        graph.get(3).add(2);
        //4-3
        graph.get(4).add(3);
        graph.get(3).add(4);
        //3-5
//        graph.get(3).add(5);
//        graph.get(5).add(3); // remove the edge between 3 and 5 to check if path exists or not
        boolean[] isVisited = new boolean[v];
        boolean isPathExists = dfs(graph,source,destination,isVisited);
        System.out.println("is Path Exists ? : " + isPathExists);
    }
    public static boolean dfs(List<List<Integer>> graph,int source,int destination,boolean[] isVisited){
        // if the current vertex is the destination vertex
        if(source == destination) return true;
        // else we came across this vertex first time and it is not destination either
        // mark this as visited
        isVisited[source] = true;
        // let's  call dfs on its neighbor
        for(int neighbor:graph.get(source)){
            // if the neighbor is not visisted then calling dfs on it
            if(!isVisited[neighbor]){
                System.out.println(neighbor);
                if(dfs(graph,neighbor,destination,isVisited))
                    return true;
            }
        }
        return false;
    }
}
