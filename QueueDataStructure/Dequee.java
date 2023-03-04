package QueueDataStructure;

import java.util.*;

public class Dequee {
    //stack using deque
    static class Stack{
        Deque<Integer> deq = new LinkedList<>();
        public void push(int data){
            deq.addLast(data);
        }
        public int pop(){
            return deq.removeLast();
        }
        public int peek(){
            return deq.getLast();
        }
    }
    //queue using deque
    static class Queue{
        Deque<Integer> deq = new LinkedList<>();
        public void add(int data){
            deq.addLast(data);
        }
        public int remove(){
            return deq.removeFirst();
        }
        public int peek(){
            return deq.getFirst();
        }
    }


    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        int top = q.peek();
        System.out.println("Top: "+top);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // int peek = s.peek();
        // System.out.println("Top: "+peek);
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // Deque<Integer> deque = new LinkedList<>();
        // deque.addFirst(1);
        // deque.addFirst(2);
        // deque.addLast(3);
        // deque.addLast(4);
        // System.out.println(deque);
        // deque.removeLast();
        // System.out.println(deque.getFirst());
        // System.out.println(deque.getLast());
    }
}
