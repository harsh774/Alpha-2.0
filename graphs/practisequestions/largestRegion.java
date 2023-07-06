package graphs.practisequestions;

import java.util.*;

public class largestRegion {
    // static class Ele{
    // int x =0, y=0;
    // public Ele(int x, int y){
    // this.x = x;
    // this.y = y;
    // }
    // }
    // public static int findRegion(int[][] mat, int r, int c) {
    // Queue<Ele> q = new LinkedList<>();
    // Ele temp;
    // int count = 0;
    // for(int i=0; i<r; i++){
    // for(int j=0; j<c; j++){
    // if(mat[i][j]==1){
    // q.add(new Ele(i, j));
    // }
    // }
    // }
    // q.add(new Ele(-1, -1));

    // while(!q.isEmpty()){
    // temp = q.peek();
    // if(isValid(mat,temp.x, temp.y)){

    // }
    // }

    // }

    static int r, c, count;

    public static int findRegion(int[][] mat) {
        // dfs
        boolean[][] vis = new boolean[r][c];
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1 && !vis[i][j]) {
                    count = 1;
                    DFS(mat, i, j, vis);
                    res = Math.max(res, count);
                }
            }
        }
        return res;

    }

    public static void DFS(int[][] mat, int row, int col, boolean[][] vis) {
        int[] rowN = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colN = { -1, 0, 1, -1, 1, -1, 0, 1 };

        vis[row][col] = true;
        for (int k = 0; k < 8; k++) {
            if (isSafe(mat, row + rowN[k], col + colN[k], vis)) {
                count++;
                DFS(mat, row + rowN[k], col + colN[k], vis);
            }
        }
    }

    public static boolean isSafe(int[][] mat, int row, int col, boolean[][] vis) {
        return (row >= 0 && row < r && col >= 0 && col < c && mat[row][col] == 1 && !vis[row][col]);
    }

    public static void main(String[] args) {
        // int[][] mat = { { 0, 0, 1, 1, 0 }, { 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0,
        // 0, 0, 0, 1 } };
        int[][] mat = { { 1, 1, 1, 1, 1 }, { 0, 1, 0, 0, 0 } };
        r = mat.length;
        c = mat[0].length;
        System.out.println(findRegion(mat));
    }
}
