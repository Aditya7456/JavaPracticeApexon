package com.practice.graph;

import java.util.Arrays;

// leetcode - 542
public class ZeroOneMatrix {
    public static void main(String[] args){
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int[][] res = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    res[i][j] = 0;
                }
                else{
                    res[i][j] = dfs(mat,res,i,j,isVisited);
                }
            }
        }
        System.out.println(Arrays.deepToString(res));
    }
    public static int dfs(int[][] mat,int[][] res,int i, int j,boolean[][] isVisited){
        // check the boundary condition
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j] ==0 || isVisited[i][j]) return 0;
        // else mark it visited
        if(mat[i][j] == 1 && !isVisited[i][j]) return 1;
        isVisited[i][j] = true;
        int up = dfs(mat,res,i-1,j,isVisited);
        int down = dfs(mat,res,i+1,j,isVisited);
        int left = dfs(mat,res,i,j-1,isVisited);
        int right = dfs(mat,res,i,j+1,isVisited);
        return 1 + Math.min(Math.min(up,down),Math.min(left,right));
    }
}
