package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
* Find time by which all oranges would be rotten.
* */
public class RottenOrangeProblem {
    static class Orange {
        int row,col,time;
        Orange(int _x, int _y, int _time){
            this.row = _x;
            this.col = _y;
            this.time = _time;
        }
    }
    private static int[][] matrix = {{2,1,0,2,1,1},{1,0,1,2,1,0},{0,0,0,2,1,0}};
    private static int m = matrix.length;
    private static int n = matrix[0].length;
    private static int[][] visited = new int[m][n];

    public static void main(String[] args) {
        Queue<Orange> queue = new LinkedList<>();
        int timeTaken = 0;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(matrix[i][j] == 2)
                    queue.add(new Orange(i,j,0));

        while (!queue.isEmpty()){
            Orange ele = queue.remove();
            visited[ele.row][ele.col]=1;
            timeTaken = ele.time;
            if(isValid(ele.row-1,ele.col)){
                queue.add(new Orange(ele.row-1,ele.col, ele.time+1));
                matrix[ele.row-1][ele.col] = 2;
            }
            if(isValid(ele.row+1, ele.col)){
                queue.add(new Orange(ele.row+1,ele.col, ele.time+1));
                matrix[ele.row+1][ele.col] = 2;
            }
            if(isValid(ele.row, ele.col+1)){
                queue.add(new Orange(ele.row, ele.col+1, ele.time+1));
                matrix[ele.row][ele.col+1] = 2;
            }
            if(isValid(ele.row, ele.col-1)){
                queue.add(new Orange(ele.row, ele.col-1, ele.time+1));
                matrix[ele.row][ele.col-1] = 2;
            }
        }
        System.out.println("Total time taken for all oranges to be rotten : " + timeTaken);
    }

    private static boolean isValid(int row, int col) {
        if(row>=0 && row<m){
           if(col>=0 && col<n && visited[row][col] != 1 && matrix[row][col]==1)
               return true;
        }
        return false;
    }
}
