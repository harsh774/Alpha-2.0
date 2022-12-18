package DSA;

import java.util.Scanner;

public class TwoDArrays {
    public static void elementcell(int matrix[][], int key){
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(key==matrix[i][j]){
                    System.out.println("Cell found at ("+i+","+j+")");
                    break;
                }
            }
        }
    }

    public static void matrixMaxandMIn(int matrix[][]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                largest = Math.max(largest, matrix[i][j]);
                smallest = Math.min(smallest, matrix[i][j]);
            }
        }
        System.out.println("Largest is "+largest);
        System.out.println("Smallest is "+smallest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                matrix[i][j]=sc.nextInt();
            }
        }

        //elementcell(matrix, 5);
        matrixMaxandMIn(matrix);

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
