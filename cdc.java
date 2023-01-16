import java.util.*;
public class cdc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][4];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                mat[i][j]=sc.nextInt();
            }
        }
        int[] sumtotal = new int[n];
        for(int i=0; i<mat.length; i++){
            int sum = 0;
            for(int j=1; j<mat[0].length; j++){
                sum+=mat[i][j];
            }
            System.out.println(sum);
            sumtotal[i]=sum;
        }
        int col = 1, bdda = 0, idx = 0;
        while(col<4){
            for(int i=0; i<mat.length; i++){
                if(mat[i][col]>bdda){
                    bdda =mat[i][col];
                    idx = i+1;
                }
            }
            System.out.println(idx+" "+bdda);
            bdda=0;
            col++;
        } 
        int bda = 0, index=0;
        for(int i=0; i<sumtotal.length; i++){
            if(sumtotal[i]>bda){
                bda = sumtotal[i];
                index = i+1;
            }
        }
        System.out.println(index+" "+bda);     
    }
}

