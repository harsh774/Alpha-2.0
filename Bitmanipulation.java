
import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;
public class Bitmanipulation {

    public static void oddOrEven(int n){
        int bitMask = 1;
        if((n & bitMask)==0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
    public static int clearBit(int n, int i){
        int bitMask = ~(1<<i);
        return n&bitMask;
    }

    public static int setBit(int n, int i){
        int bitMask = i<<i;
        return n|bitMask;
    }

    public static int updateBit(int n, int i, int newBit){
        n = clearBit(n, i);
        int bitMask = newBit<<i;
        return n|bitMask;

    }

    public static int clearlastbits(int n, int i){
        int bitMask = (-1)<<i;
        return n&bitMask;
    }

    public static int clearRangeBits(int n, int i, int j){
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int bitMask = a|b;
        return n&bitMask;
    }

    public static boolean isPowerofTwo(int n){
        return (n&(n-1))==0;
    }

    public static int countsetBits(int n){
        int count=0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public static double fastexpo(int n, double a){
        double ans =1;
        while(n>0){
            if((n&1)!=0){
                ans = ans*a;
            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }

    //swap without temp
    public static void swapwithoutTemp(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
    }
    public static void main(String[] args) {
        // oddOrEven(9);
        // System.out.println(updateBit(10, 2, 5)); 

        // System.out.println(clearRangeBits(10, 2, 4));

        // System.out.println(isPowerofTwo(15));
        // System.out.println(isPowerofTwo(8));
        // System.out.println(countsetBits(10));
        // System.out.println(countsetBits(16));
        // System.out.println(countsetBits(15));
        // System.out.println(fastexpo(10, 2.00000));
        // System.out.println(fastexpo(3, 5.00000));
        int n1 = 5, n2 = 3;
        swapwithoutTemp(n1, n2);
        System.out.println("n1: "+n1+"n2: "+n2);


    }
}
