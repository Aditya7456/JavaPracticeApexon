package com.practice.graph;

import java.util.Arrays;

// leetcode - 130
public class SurroundedRegions {
    public static void main(String[] args){
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        // calling dfs on first and last row boundary
        /*
         * * * *
         - - - -
         - - - -
         * * * *
         */
        for(int j=0; j<n; j++){
            dfs(board,isVisited,0,j);
            dfs(board,isVisited,m-1,j);
        }
        // calling dfs on first and last column
        /*
         * - - *
         * - - *
         * - - *
         * - - *
         */
        for(int i=0; i<m; i++){
            dfs(board,isVisited,i,0);
            dfs(board,isVisited,i,n-1);
        }
        //now let's convert surrounded region of O to X
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O' && !isVisited[i][j]){
                    board[i][j]='X';
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
        System.out.println(Arrays.deepToString(isVisited));
    }
    public static void dfs(char[][] board,boolean[][] isVisited,int i, int j){
        // check the boundary and base case
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == 'X' || isVisited[i][j]) return;
        // now let's mark this visited
        isVisited[i][j] = true;
        dfs(board,isVisited,i-1,j);
        dfs(board,isVisited,i+1,j);
        dfs(board,isVisited,i,j-1);
        dfs(board,isVisited,i,j+1);
    }
}
