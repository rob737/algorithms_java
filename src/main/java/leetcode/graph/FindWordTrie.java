package leetcode.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWordTrie {
    private static int M,N;
    private static int[] row = {-1,-1,-1,0,1,0,1,1};
    private static int[] col = {-1,1,0,-1,-1,1,0,1};

    public static void main(String[] args) {
        char[][] board = {{'M','S','E'},{'R','A','T'},{'L','O','N'}};
        M = board.length;
        N = board[0].length;
        List<String> words = Arrays.asList("STAR","NOTE","SAND","STONE");
        searchBoggle(board,words);
    }

    private static void searchBoggle(char[][] board, List<String> input) {
        boolean[][] visited = new boolean[M][N];
        Set<String> words = new HashSet<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                searchBoggle(board,words,visited,i,j,"");
            }
        }
        for(String word:input){
            if(words.contains(word))
                System.out.println(word);
        }
    }

    private static void searchBoggle(char[][] board, Set<String> words, boolean[][] visited, int i, int j, String path) {
            visited[i][j]=true;
            path=path+board[i][j];
            words.add(path);
            for(int k=0; k<8; k++){
                if(isSafe(i+row[k],j+col[k],visited)){
                    searchBoggle(board,words,visited,i+row[k],j+col[k],path);
                }
            }
            visited[i][j]=false;
    }

    private static boolean isSafe(int x, int y, boolean[][] visited) {
        return (x >= 0 && x<M) && (y>=0 && y < N) && !visited[x][y];
    }
}
