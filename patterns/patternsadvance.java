package patterns;

public class patternsadvance {
    public static void hollow_rectangle(int rows, int col) {

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= col; j++) {
                if (i == 1 || i == rows || j == 1 || j == col) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Inverted and Rotated half pyramid
    public static void InvertedandRotated_HalfPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // stars
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    // Inverted half pyramid
    public static void InvertedPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

    }

    // FLOYD'S Triangle
    public static void FLOYD(int n) {
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter);
                counter++;
            }
            System.out.println();
        }
    }

    // 0-1 Triangle

    public static void ZeroOneTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int pos = i + j;
                if (pos % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hollow Rectangle:-");
        System.out.println();

        hollow_rectangle(8, 15);
        System.out.println();

        System.out.println("Inverted&ROtatedPyramid:-");
        System.out.println();

        InvertedandRotated_HalfPyramid(5);
        System.out.println();

        System.out.println("Inverted Half Pyramid: -");
        System.out.println();
        InvertedPyramid(5);
        System.out.println();

        System.out.println("FLOYD'S Triangle:-");
        System.out.println();
        FLOYD(5);
        System.out.println();

        System.out.println("0 - 1 Triangle:- ");
        System.out.println();
        ZeroOneTriangle(5);
        System.out.println();
    }

}
