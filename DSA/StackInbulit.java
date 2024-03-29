package DSA;

import java.util.*;

public class StackInbulit {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder res = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            res.append(curr);
        }
        return res.toString();
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    //Stock Span Problem
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1; i<stocks.length; i++){
            int curPrice = stocks[i];
            while(!s.isEmpty() && curPrice>=stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh = s.peek();
                span[i]=i-prevHigh;
            }
            s.push(i);
        }
    }

    //nextGreaterElement O(n) 
    public static void nextGreaterElements(int[] arr, int[] G){
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty()&& arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                G[i]=-1;
            }else{
                G[i]=arr[s.peek()];
            }
            
            s.push(i);
        }
    }
    //validParanthesis O(n)
    public static boolean isValidPar(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek()=='(' && ch==')') || (s.peek()=='{' && ch=='}') || (s.peek()=='[' && ch==']')){
                    s.pop();
                }else{
                    return false;
                }
            }

        }
        if(s.isEmpty()){
            return true;
        }else return false;
    }

    //Duplicate Paranthesis 
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            
            //closing 
            if(ch==')'){
                int count = 0;
                while(s.pop()!='('){
                    count++;
                }
                if(count<1) return true; //duplicate found
            }else s.push(ch);
        }
        return false;
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        // String str = "Harsh Singh Kushwaha";
        // String result = reverseString(str);
        // System.out.println(result);
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // // // pushAtBottom(s,4);
        // printStack(s);
        // reverseStack(s);
        // printStack(s);
        // int stocks[] = {100,80,60,70,60,85,100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);
        // for(int i=0; i<span.length; i++){
        //     System.out.println(span[i]+" ");
        // }
        // int arr[] = {4,6,0,9,2,1};
        // int nextGreater[] = new int[arr.length];
        // nextGreaterElements(arr, nextGreater);
        // for(int i=0; i<nextGreater.length; i++){
        //     System.out.print(nextGreater[i]+" ");
        // }
        // System.out.println();
        // String str = "({})[]";
        // System.out.println(isValidPar(str));
        String str = "((a+b)+(c+d))";
        System.out.println(isDuplicate(str));

        
        
    }
}
