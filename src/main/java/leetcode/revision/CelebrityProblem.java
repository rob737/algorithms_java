package leetcode.revision;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] relationship = {
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0},
                {0,0,1,0}
        };
        int celebrity = findCelebrity(relationship);
        if(celebrity == -1)
            System.out.println("No celebrity found");
        else
            System.out.printf("%d is the celebrity", celebrity+1);

    }

    // If X knows Y then X is definitely not a celebrity.
    // If Y knows X then Y is definitely not a celebrity.
    private static int findCelebrity(int[][] relationship) {
        int x=0,y=relationship[0].length-1, n = relationship[0].length;

        while (x < y){
            if(relationship[x][y] == 1)
                x++;
            else
                y--;
        }
        for(int i=0; i<n; i++){
            if( i!=x && !(relationship[i][x] == 1 && relationship[x][i] == 0))
                return -1;
        }
        return x;
    }
}
