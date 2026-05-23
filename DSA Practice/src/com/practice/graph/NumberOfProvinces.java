package com.practice.graph;

public class NumberOfProvinces {
    public static void main(String[] args){
        int[][] isConnected = {
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        // if isConnected[i][j] is 1 that means there is a connection between i and j city
        boolean[] isVisited = new boolean[isConnected.length+1];
        int count = 0;
        for(int i=0; i<isConnected.length; i++){
            if (!isVisited[i]) {
                count++;
                dfs(isConnected,i,isVisited);
            }
        }
        System.out.println(count);
    }
    public static void dfs(int[][] isConnected,int city, boolean[] isVisited){
        // then let's mark it visited first
        isVisited[city] = true;
        for(int neighbor = 0; neighbor<isConnected[0].length; neighbor++){
            if(isConnected[city][neighbor] == 1 && !isVisited[neighbor]){
                dfs(isConnected,neighbor,isVisited);
            }
        }
    }
}
