package com.practice.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// leetcode 1020
public class NumberOfEnclaves {
    public static void main(String[] args){
        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        int m = grid.length;
        int n = grid[0].length;
        int[][] isVisited = new int[grid.length][grid[0].length];
        // traversing the boundary of row
        for(int i=0; i<m; i++){
            dfs(grid,isVisited,i,0);
            dfs(grid,isVisited,i,n-1);
        }
        /*
            * - - *
            * - - *
            * - - *
            * - - *
         */
        // traversing the boundary of column
        for(int i=0; i<n; i++){
            dfs(grid,isVisited,0,i);
            dfs(grid,isVisited,m-1,i);
        }
        /*
         * * * *
         - - - -
         - - - -
         * * * *
         */
        // count remaining land
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && isVisited[i][j] == 0){
                    count++;
                }
            }
        }
        System.out.println("Number of Enclaves : " + count);

    }
    public static void dfs(int[][] grid,int[][] isVisited,int i , int j){
        int m = grid.length;
        int n = grid[0].length;

        // now checking the boundary condition and if it is visited
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]== 0 || isVisited[i][j]==1) return;

        // now it is not visited then mark is visited
        isVisited[i][j] = 1;

        dfs(grid,isVisited,i-1,j);
        dfs(grid,isVisited,i+1,j);
        dfs(grid,isVisited,i,j-1);
        dfs(grid,isVisited,i,j+1);
    }

}
