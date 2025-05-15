package leetcode.revision;

public class ElementInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10,20,30,40},
                {15,25,36,46},
                {28,29,37,48},
                {32,33,39,50}
        };
        String result = findElementInMatrix(matrix);
        System.out.println(result);
    }

    private static String findElementInMatrix(int[][] matrix) {
        int n = matrix.length,i=0;
        int r=n,c=n,j=n-1, target = 15;

        while(i<r && j>=0){
            if(target > matrix[i][j])
                i++;
            else if(target < matrix[i][j])
                j--;
            else
                return "Found at " + i + "," + j;
        }

        return "Not found";
    }
}
