package leetcode.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class PathFromTopToBottom {
    static class Coordinate{
        int row,col;
        Coordinate(int x, int y ){
            this.row=x;
            this.col=y;
        }
    }

    static byte[][] matrix = {
            {1,0,0,0,0},
            {1,0,1,1,1},
            {1,1,1,0,1},
            {1,0,0,0,1},
            {1,0,0,0,1}
    };
    static byte[][] visited = new byte[5][5];

    private static boolean isReached = false;
    private static Stack<Coordinate> stack = new Stack<>();

    public static void main(String[] args) {
        // Assumption : (0,0) is 1 always
        dfs(0,0);
        System.out.println("Path from top left to bottom right");
        Iterator ele = stack.iterator();
        while (ele.hasNext()){
            Coordinate item = (Coordinate) ele.next();
            System.out.println(item.row + " ," + item.col);
        }
    }

    private static boolean dfs(int row, int col) {
        int m = 5, n =5;

        if(row==m-1 && col == n-1){
            stack.push(new Coordinate(row,col));
            isReached = true;
            return true;
        }
        if(row>=n || row < 0)
            return false;
        if(col>=n || col < 0)
            return false;
        if(visited[row][col] == 1){
            return false;
        }

        boolean resBottom=false,resRight=false,resLeft=false,resUp=false;
        if(matrix[row][col]==1 && !isReached){
            stack.push(new Coordinate(row,col));
            visited[row][col]=1;
            resBottom = dfs(row+1,col);
            resRight = dfs(row,col+1);
            resLeft = dfs(row,col-1);
            resUp = dfs(row-1,col);

            if(resBottom == false && resRight == false && resLeft == false && resUp == false)
                stack.pop();
        }
        return resBottom||resUp||resRight||resLeft;
    }
}
