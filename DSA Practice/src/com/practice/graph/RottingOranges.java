package com.practice.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pairs{
    int i;
    int j;
    int time;

    public Pairs(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
}
public class RottingOranges {
    public static void main(String[] args){
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        int[][] isVisited = new int[grid.length][grid[0].length];
        Queue<Pairs> queue = new LinkedList<>();
        int countFresh = 0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    isVisited[i][j] = 2;
                    queue.add(new Pairs(i,j,0));
                }
                else{
                    isVisited[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }
        //System.out.println(Arrays.deepToString(isVisited));
        int tm = 0;
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};
        int cnt = 0;
        while(!queue.isEmpty()){
            int r = queue.peek().i;
            int c = queue.peek().j;
            int t = queue.peek().time;
            tm = Math.max(tm,t);
            queue.remove();
            // we need to check all four neighbor
            for(int i=0; i<4; i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow>=0 && nrow < grid.length && ncol>=0 && ncol<grid[0].length
                && isVisited[nrow][ncol]== 0 && grid[nrow][ncol]==1){
                    queue.add(new Pairs(nrow,ncol,t+1));
                    isVisited[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt!=countFresh) System.out.println("-1");
        System.out.println(tm);
    }
}
