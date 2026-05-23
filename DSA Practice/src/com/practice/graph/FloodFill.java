package com.practice.graph;

import java.util.Arrays;

// Leetcode - 733(Graph)
public class FloodFill {
    public static void main(String[] args){
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int sr = 1, sc = 1, color = 2;
        int[][] res= floodFill(image,sr,sc,color);
        System.out.println(Arrays.deepToString(res));
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color){
        int originalColor = image[sr][sc];
        // if we already have the same color on the source pixel then do nothing
        if(image[sr][sc] == color) return image;
        dfs(image,sr,sr,color,originalColor);
        return image;
    }
    public static void dfs(int[][] image,int sr, int sc, int color, int originalColor){
        // need to check first boundary condition, return from there
        if(sr<0 || sr>= image.length || sc<0 || sc>=image[0].length) return;
        // if the current pixel is not same as original Color then do return
        if(image[sr][sc]!=originalColor) return;
        // now let's color on that source pixel with the given color
        image[sr][sc] = color;
        // now let's call dfs on all side
        dfs(image,sr+1,sc,color,originalColor);
        dfs(image,sr-1,sc,color,originalColor);
        dfs(image,sr,sc+1,color,originalColor);
        dfs(image,sr,sc-1,color,originalColor);
    }
}
