package leetcode.backtrack;

import java.util.ArrayList;

/**
 * Basically find a path from start to end when some blockers are given in between
 *
 * */
public class RatMazeProblem {
    private static int N;
    private static int[][] path;
    public static void main(String[] args) {
        int[][] matrix = {{0,1,0,1,1},{0,0,0,0,0},{1,0,1,0,1},{0,0,1,0,0},{1,0,0,1,0}};
        N = matrix[0].length;
        path = new int[N][N];
        boolean isJourneyCompleted = pathToDestination(matrix,0,0);

        if(!isJourneyCompleted)
            System.out.println("Unable to reach destination");
        else{
            System.out.println("Path to destination is as follows");
            for(int i=0;i< matrix.length;i++){
                for (int j=0;j<matrix.length;j++)
                    System.out.printf("%s ", matrix[i][j]);
                System.out.println();
            }
        }

    }

    private static boolean pathToDestination(int[][] matrix, int row, int col) {
        if((row >= N || col >= N) || matrix[row][col] == 1)
            return false;
        if(row == N-1 && col == N-1){
            matrix[row][col] = 8;
            return true;
        }
        matrix[row][col]=8;
        boolean forward = pathToDestination(matrix,row,col+1);
        boolean down = pathToDestination(matrix,row+1,col);
        if(!(forward||down))
            matrix[row][col]=0;

        return forward||down;
    }
}
