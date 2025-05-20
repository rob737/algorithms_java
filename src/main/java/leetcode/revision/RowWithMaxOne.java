package leetcode.revision;

public class RowWithMaxOne {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,1},
                {0,0,1,1},
                {0,0,0,1},
                {1,1,1,1}
        };
        int row = matrix.length, col = matrix[0].length, maxRow=matrix.length, curr = matrix.length, prev = matrix.length;
        for(int i=0; i<row; i++){
            curr = findLeftMostSetIndex(0,col-1,matrix[i]);
            if(curr < prev) {
                maxRow = i;
                prev = curr;
            }
        }
        System.out.println("Row with maximum One : " + maxRow);
    }

    private static int findLeftMostSetIndex(int begin, int end, int[] row) {
        int mid = (begin + end)/2;
        if(begin >= end)
            return mid;
        if(row[mid] == 1)
            return findLeftMostSetIndex(begin,mid,row);
        else
            return findLeftMostSetIndex(mid+1,end, row);
    }
}
