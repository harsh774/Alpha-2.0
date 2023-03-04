package QueueDataStructure;

import java.util.*;
public class QueueJCB {
    //reverse
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    //Generating N binary numbers
    public static void generateBinary(int n){
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n>0){
            String s1 = q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1+"0");
            q.add(s2+"1");
            n--;
        }
    }
    //Connect n ropes with minimum cost
    public static int minCost(int arr[], int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }
        int res = 0;
        while(pq.size()>1){
            int first = pq.poll();
            int sec = pq.poll();
            res += first+sec;
            pq.add(first+sec);
        }
        return res;
    }
    //reversing first K element of Queue
    public static void reverseK(Queue<Integer> q, int k){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for(int i=0; i<k; i++){
            s1.push(q.remove());
        }
        while(!q.isEmpty()){
            s2.push(q.remove());
        }
        while(!s1.isEmpty()){
            q.add(s1.pop());
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        while(!s1.isEmpty()){
            q.add(s1.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        reverseK(q,5);
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }

        // int n = 10;
        // generateBinary(n);

        // int len[] = {4,3,2,6};
        // int size = len.length;
        // System.out.println("total cost for connecting: "+minCost(len, size));
    }
}
