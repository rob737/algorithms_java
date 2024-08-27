package leetcode.backtrack;

public class Sudoku {

    static class NextPos{
        int x, y;
        NextPos(int x, int y){
            this.x=x;
            this.y = y;
        }
    }

    private static int [][] rowCheck = {
            {0,0,1,1,1,1,0,1,0},
            {0,1,0,0,1,0,0,0,0},
            {1,0,1,0,0,0,1,1,0},
            {1,0,1,0,0,0,0,1,0},
            {0,0,1,0,1,1,0,1,1},
            {0,0,0,0,1,1,0,0,1},
            {1,1,1,0,1,0,0,0,0},
            {0,0,0,1,0,0,1,0,0},
            {0,1,1,0,1,1,0,0,0}
    };

    private static int [][] colCheck = {
            {1,0,1,0,1,0,0,0,1},
            {0,1,1,0,1,0,0,1,0},
            {0,0,1,0,1,1,1,0,0},
            {0,1,0,0,1,0,0,1,0},
            {1,0,0,0,0,1,0,0,1},
            {0,0,1,0,0,1,0,1,0},
            {0,1,1,1,0,1,0,0,0},
            {0,0,1,0,1,0,1,1,0},
            {1,0,0,1,1,0,0,0,0}
    };

    private static int [][] blockCheck = {//row*3+col
            {0,1,1,0,1,1,1,1,0},
            {0,0,0,0,1,0,0,1,0},
            {1,0,1,1,0,0,0,0,0},
            {0,0,1,0,1,0,0,0,1},
            {1,0,1,0,0,1,0,1,1},
            {0,0,0,0,1,1,0,1,0},
            {1,0,1,0,1,0,0,0,0},
            {0,1,0,0,0,1,0,0,0},
            {0,1,1,1,1,0,1,0,0}
    };

    public static void main(String[] args) {
        int [][] board = {
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };

        if(completeSudoku(board))
            System.out.println("Sudoku solved");
        else
            System.out.println("Sudoku not feasible...");
        for(int i=0; i<9;i++){
            for(int j=0;j<9;j++)
                System.out.printf("%s ", board[i][j]);
            System.out.println();

        }
    }

    private static boolean completeSudoku(int[][] board) {

        NextPos pos = findEmptyPos(board);
        int row = pos.x;
        int col = pos.y;

        if(row == -1 || col == -1)
            return false;

        for(int i=1; i<=9; i++){
            if(isValid(row,col,i)){
               board[row][col] = i;

               if(completeSudoku(board))
                   return true;
               board[row][col]=0;
                int offset=0;
                if(row>=2 && row<=5)
                    offset = 1;
                if(row>=6 && row<=8)
                    offset=2;

                /*int block = offset*3+col/3;

               rowCheck[row][i-1] = 0;
               colCheck[col][i-1]=0;
               blockCheck[block][i-1]=0;*/
            }
        }
        return false;
    }

    private static NextPos findEmptyPos(int[][] board) {
        for(int i =0; i<9; i++)
            for(int j=0;j<9;j++)
                if(board[i][j] == 0)
                    return new NextPos(i,j);
        return new NextPos(-1,-1);
    }

    private static boolean isValid(int row, int col, int num) {
        int offset=0;
        if(row>=2 && row<=5)
            offset = 1;
        if(row>=6 && row<=8)
            offset=2;

        int block = offset*3+col/3;

        if(rowCheck[row][num-1] == 1)
            return false;
        if(colCheck[col][num-1] == 1)
            return false;
        if(blockCheck[block][num-1] == 1)
            return false;
        /*rowCheck[row][num-1] = 1;
        colCheck[col][num-1] = 1;
        blockCheck[block][num-1] =1;*/
        return true;
    }
}
