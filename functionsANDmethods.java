import java.util.*;
public class functionsANDmethods {
    // public static boolean prime(int n){
    //     if(n==2){
    //         return true;
    //     }
    //     for(int i = 2; i<=n-1; i++){
    //         if(n%i==0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    //CHeck prime
    public static boolean isPrime(int n){
        if(n==2){
            return true;
        }
        for(int i = 2; i<=(Math.sqrt(n)); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    //print prime 2 to n;
    public static void primesInRange(int n){
        for(int i = 2; i<=n; i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    //convert binary to decimal
    public static void BintoDec(int binNum){
        int pow = 0, decNum = 0;
        while(binNum>0){
            int lastdigit = binNum%10;
            decNum = decNum + (lastdigit*(int)Math.pow(2, pow));
            pow++;
            binNum = binNum/10;
        }
        System.out.println(decNum);
    }

    //covert decimal to Binary
    public static void DectoBin(int DecNum){
        int pow = 0, BinNum = 0;
        while(DecNum>0){
            int rem = DecNum%2;
            BinNum = BinNum+ rem*(int)Math.pow(10, pow);
            pow++;
            DecNum=DecNum/2;
        }
        System.out.println(BinNum);
    }

    //average of three numbers
    public static double average(double a, double b, double c){
        return (a+b+c)/3;
        
    
    }

    //Number is even or not
    public static boolean isEven(int num){
        
        if(num%2==0){
            return true;
        }

        return false;

    }

    //pallindrome
    public static boolean isPalindrome(int n){
        int revNum = 0, pow = 0;
        int orginalN0 = n;
        while(n>0){
            int lastdigit = n%10;
            revNum = revNum + lastdigit*(int)Math.pow(10, pow);
            pow++;
            n = n/10;
        }
        if(orginalN0 == revNum){
            return true;
        }
        return false;
    }

    //Sum of Digits of an integer.
    public static void sumofDigits(int n){
        int sum = 0;
        int myNum = n;
        while(n>0){
            int lastdigit = n%10;
            sum = sum + lastdigit;
            n = n/10;
        }
        System.out.println("Sum of digits of "+myNum+" is"+sum);
    }


    public static void main(String[] args) {
        // BintoDec(101);
        // DectoBin(11);
        // System.out.println(average(2, 5, 9));
        // System.out.println(isEven(11));
        // System.out.println(isEven(16));
        //System.out.println(isPalindrome(123));
        //System.out.println(isPalindrome(525));
        // sumofDigits(1234567891);
        // int count = 1;
        // while( count<=15){
        //     System.out.println(count%2==1? "***": "++++");
        //     ++count;
        // }

        for( ; ;){
            System.out.println("h");
        }

    }
}