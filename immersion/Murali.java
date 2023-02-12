package immersion;

import java.util.*;
public class Murali {
    static int countPairs(int arr[], int n){
        int forward[] = new int[n];
        Stack<Integer> sForward = new Stack<Integer>();
        for (int i = 0; i < n; i++)
        {
            while (!sForward.empty()
                && arr[i] > arr[(Integer)sForward.peek()])
            {
                forward[(Integer)sForward.peek()] = 1;
                sForward.pop();
            }
            sForward.push(i);
        }
        int backward [] = new int[n] ;
        Stack<Integer> sBackward = new Stack<Integer>() ;
        for (int i = n - 1; i >= 0; i--)
        {
            while (!sBackward.empty()
                && arr[i] > arr[(Integer)sBackward.peek()])
            {
                backward[(Integer)sBackward.peek()] = 1;
                sBackward.pop();
            }
            sBackward.push(i);
        }
     
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            res += forward[i] + backward[i];
        }
        return res;
    }
     
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(countPairs(arr, n));
    }

}



        
