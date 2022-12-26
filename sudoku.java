public class sudoku {
    public static boolean sudokusolver(int sudoku[][], int row, int col){
        //base case
        if(row==9 && col == 9){
            nextRow
        }
        //recursion
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        
        if(sudoku[row][col]!=0){
            return sudokusolver(sudoku, nextRow, nextCol);
        }

        for(int digit = 1; digit<=9; digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokusolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
