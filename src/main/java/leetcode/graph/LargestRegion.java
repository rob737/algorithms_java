package leetcode.graph;

import java.util.LinkedList;

public class LargestRegion {
    static class Coordinate {
        int x,y;
        Coordinate(int _x, int _y){
            this.x=_x;
            this.y=_y;
        }
    }

    private static int largestRegion=Integer.MIN_VALUE;
    private static byte[][] matrix = {
            {0,0,1,1,0},
            {1,0,1,1,0},
            {0,1,0,0,0},
            {0,0,0,0,1},
            {0,0,0,0,0}
    };

    public static void main(String[] args) {
        int m= matrix.length, n=matrix[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j]=0;
                    traverseConnectedLand(i,j,m,n);
                }
            }
        }
        System.out.println("Length of largest region : "+ largestRegion);
    }


    private static void traverseConnectedLand(int x, int y, int m, int n) {
        Coordinate point = new Coordinate(x,y);
        LinkedList<Coordinate> queue = new LinkedList<>();
        int currentArea = 0;
        queue.add(point);

        while(!queue.isEmpty()){
            Coordinate ref = queue.remove();
            currentArea++;
            if(currentArea>largestRegion)
                largestRegion=currentArea;

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
