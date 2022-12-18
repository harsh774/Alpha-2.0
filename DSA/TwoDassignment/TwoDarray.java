package DSA.TwoDassignment;

public class TwoDarray {
    public static int ques1(int matrix[][]){
        int count=0;
        for(int i =0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==7){
                    count++;
                }
            }
        }
        return count;
    }

    public static int ques2(int matrix[][]){
        int sum = 0;
        int row = 1;
        for(int j = 0; j<matrix[0].length; j++){
            sum+=matrix[row][j];
        }
        return sum;
    }

    public static boolean ques3(int matrix[][]){
        int row = matrix.length, col = matrix[0].length;

        for(int j=0; j<col; j++){
            for(int i=0; i<row; i++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        return true;
    }

    public static void main(String[] args) {
        //int matrix1[][] = {{4,7,8},{8,8,7}};
        //System.out.println("No. of 7's = "+ques1(matrix1));

        //int matrix2[][]= {{1,4,9},{11,4,3},{2,2,3}};
        //System.out.println("Sum of second row = "+ques2(matrix2));

        int matrix3[][] = {{1,2,3},{4,5,6}};
        ques3(matrix3);

    }
}
