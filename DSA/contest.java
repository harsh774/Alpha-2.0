package DSA;

public class contest {
        public int numberOfCuts(int n) {
            if(n==1){
                return 0;
            }
            int completeCircle = 360;
            int onepart = 360/n;
            
            float ans = 180f/onepart;
            if(n%2==0){
                return (int)ans;
            }else{
                float newans = ans*2;
                return (int)newans;
            }
        }
    }
    Input: grid = [[0,1,1],[1,0,1],[0,0,1]]
    Output: [[0,0,4],[0,0,4],[-2,-2,2]]
    Explanation:
    - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 2 + 1 - 1 - 2 = 0 
    - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 2 + 1 - 1 - 2 = 0 
    - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 2 + 3 - 1 - 0 = 4 
    - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 2 + 1 - 1 - 2 = 0 
    - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 2 + 1 - 1 - 2 = 0 
    - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 2 + 3 - 1 - 0 = 4 
    - diff[2][0] = onesRow2 + onesCol0 - zerosRow2 - zerosCol0 = 1 + 1 - 2 - 2 = -2
    - diff[2][1] = onesRow2 + onesCol1 - zerosRow2 - zerosCol1 = 1 + 1 - 2 - 2 = -2
    - diff[2][2] = onesRow2 + onesCol2 - zerosRow2 - zerosCol2 = 1 + 3 - 2 - 0 = 2



    class Solution {
        public int[][] onesMinusZeros(int[][] grid) {
            public static int onesRow(int i){
                int count = 0;
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j]==1){
                        count++;
                    }
                }
                return count;
            }
            
            public static int zerosRow(int i){
                int count = 0;
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j]==0){
                        count++;
                    }
                }
                return;
            }
            
            public static int onesCol(int j){
                int count =0;
                for(int i=0; i<grid.length; i++){
                    if(grid[i][j]==1){
                        count++;
                    }
                }
                return count;
            }
            
            public static int zerosCol(int j){
                int count =0;
                for(int i=0; i<grid.length; i++){
                    if(grid[i][j]==0){
                        count++;
                    }
                }
                return count;
            }
            
            
            public static int ans(int i, int j){
                return onesRow[i]+onesCol[j]-zerosRow[i]-zerosCol[j];
            }
            
            int diff[][] = new int[grid.length][grid[0].length];
            for(int i = 0; i<grid.length; i++){
                for(int j = 0; j<grid[0].length; j++){
                    diff[i][j]= ans[i,j];
                }
            }
        }
    }