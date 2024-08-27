package leetcode.graph;

import java.util.LinkedList;

public class NumberOfIsland {
    static class Coordinate {
        int x,y;
        Coordinate(int _x, int _y){
            this.x=_x;
            this.y=_y;
        }
    }

    private static int num_of_inslands=0;
    private static byte[][] matrix = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,1}
    };

    public static void main(String[] args) {
        int m=4,n=5;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1){
                    traverseConnectedLand(i,j,m,n);
                    num_of_inslands++;
                }
            }
        }
        System.out.println("Number of islands : "+ num_of_inslands);
    }


    private static void traverseConnectedLand(int x, int y, int m, int n) {
        Coordinate point = new Coordinate(x,y);
        LinkedList<Coordinate> queue = new LinkedList<>();
        queue.add(point);

        while(!queue.isEmpty()){
            Coordinate ref = queue.remove();

            if( ref.x+1 < m && matrix[ref.x+1][ref.y] == 1){
                queue.add(new Coordinate(ref.x+1,ref.y));
                matrix[ref.x+1][ref.y] = 0;
            }

            if( ref.x-1 >= 0 && matrix[ref.x-1][ref.y] == 1){
                queue.add(new Coordinate(ref.x-1,ref.y));
                matrix[ref.x-1][ref.y] = 0;
            }

            if(ref.y+1 < n && matrix[ref.x][ref.y+1] == 1){
                queue.add(new Coordinate(ref.x, ref.y+1));
                matrix[ref.x][ref.y+1] = 0;
            }

            if(ref.y-1 >=0 && matrix[ref.x][ref.y-1] == 1){
                queue.add(new Coordinate(ref.x, ref.y-1));
                matrix[ref.x][ref.y-1] = 0;
            }

            if(ref.x+1 < m && ref.y + 1 < n && matrix[ref.x+1][ref.y+1] == 1){
                queue.add(new Coordinate(ref.x+1, ref.y+1));
                matrix[ref.x+1][ref.y+1] = 0;
            }

            if( ref.x-1 >=0 && ref.y-1 >= 0 && matrix[ref.x-1][ref.y-1]==1){
                queue.add(new Coordinate(ref.x-1, ref.y-1));
                matrix[ref.x-1][ref.y-1]=0;
            }

            if(ref.x-1 >=0 && ref.y+1 <n && matrix[ref.x-1][ref.y+1]==1){
                queue.add(new Coordinate(ref.x-1,ref.y+1));
                matrix[ref.x-1][ref.y+1]=0;
            }

            if(ref.x+1 <m && ref.y-1>=0 && matrix[ref.x+1][ref.y-1]==1){
                queue.add(new Coordinate(ref.x+1, ref.y-1));
                matrix[ref.x+1][ref.y-1]=0;
            }

        }

    }


}
