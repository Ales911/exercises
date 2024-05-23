package com.example.exercises.leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class FloodFill733 {

    void floodFill(int[][] image, int sr, int sc, int color, int colorTo) {
        if (image[sr][sc] == color || image[sr][sc] != colorTo) {
            return;
        }

        image[sr][sc] = color;
        if (sr > 0) {
            floodFill(image, sr - 1, sc, color, colorTo);
        }
        if (sc > 0) {
            floodFill(image, sr, sc - 1, color, colorTo);
        }
        if (sr < image.length - 1) {
            floodFill(image, sr + 1, sc, color, colorTo);
        }
        if (sc < image[sr].length - 1) {
            floodFill(image, sr, sc + 1, color, colorTo);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFill(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    @Test
    public void test11() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(image, 0, 0, 2);
        for (int i = 0; i <= image.length - 1; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
    }
    
    @Test
    public void test12() {
        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        floodFill(image, 0, 0, 2);
        for (int i = 0; i <= image.length - 1; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
    }
    
    @Test
    public void test13() {
        int[][] image = {{0,0,0},{0,1,0}};
        floodFill(image, 0, 0, 2);
        for (int i = 0; i <= image.length - 1; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
    }

}