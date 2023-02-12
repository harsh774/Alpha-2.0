package immersion;
// import java.util.*;
// public class cdc {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[][] mat = new int[n][4];
//         for(int i=0; i<mat.length; i++){
//             for(int j=0; j<mat[0].length; j++){
//                 mat[i][j]=sc.nextInt();
//             }
//         }
//         int[] sumtotal = new int[n];
//         for(int i=0; i<mat.length; i++){
//             int sum = 0;
//             for(int j=1; j<mat[0].length; j++){
//                 sum+=mat[i][j];
//             }
//             System.out.println(sum);
//             sumtotal[i]=sum;
//         }
//         int col = 1, bdda = 0, idx = 0;
//         while(col<4){
//             for(int i=0; i<mat.length; i++){
//                 if(mat[i][col]>bdda){
//                     bdda =mat[i][col];
//                     idx = i+1;
//                 }
//             }
//             System.out.println(idx+" "+bdda);
//             bdda=0;
//             col++;
//         } 
//         int bda = 0, index=0;
//         for(int i=0; i<sumtotal.length; i++){
//             if(sumtotal[i]>bda){
//                 bda = sumtotal[i];
//                 index = i+1;
//             }
//         }
//         System.out.println(index+" "+bda);     
//     }
// }

import java.util.Scanner;

// import java.util.Scanner;

// public class cdc{
//     public static String numberConversion(String num, char from, char to){
//         int s=0,d=0;
//         if(from=='D')s=10;
//         if(from=='B')s=2;
//         if(from=='O')s=8;
//         if(from=='H')s=16;
//         if(to=='D')d=10;
//         if(to=='B')d=2;
//         if(to=='O')d=8;
//         if(to=='H')d=16;

//         return Integer.toString(Integer.parseInt(num, s), d);
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         char from = sc.nextLine().charAt(0);
//         char to = sc.nextLine().charAt(0);
//         String num = sc.nextLine();
//         System.out.println(numberConversion(num,from,to));

//     }
// }

/**
 * cdc
 */
// public class cdc {
class Telephone{
        String name, ph;
        Telephone(String x1, String x2){
            name = x1;
            ph = x2;
        }
        void input(){
            Scanner sc = new Scanner(System.in);

            String s1 = sc.next();
            String s2 = sc.next();
        }
        void display(){
            System.out.print(this.name+" ");
            System.out.println(this.ph);
        }
    // }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Telephone tp[] = new Telephone[2*n];
        for(int i=0; i<2*n; i++){
            String s1 = sc.next();
            String s2 = sc.next();
            tp[i]=new Telephone(s1, s2);
        }
        
        String ser = sc.nextLine();
        for(int i=0; i<2*n; i++){
            if(tp[i].name.equals(ser)){
                tp[i].display();
            }
        }

    }
}