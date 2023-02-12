package linkedlist;


// import java.util.LongSummaryStatistics;

public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //methods
    //1- add Nodes
    public void addFirst(int data){ //O(1)
        //step1=create new node
        Node newNode = new Node(data);

        size++; //size increasing

        if(head==null){
            head = tail = newNode;
            return;
        }

        //step2=newNode.next = head
        newNode.next = head; //Link

        //step3= head=newNode
        head = newNode;
    }

    public void addLast(int data){ //O(1)
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next = newNode; //link
        tail = newNode;
    }

    public void add(int idx, int data){ //O(1)
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i<idx-1){ //O(n)
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }


    //2- Remove Nodes
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size ==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    //iterative search for a key in LinkedList
    public int itrSearch(int key){ //O(n)
        Node temp = head;
        int i=0;
        while(temp.next!=null){
            if(temp.data==key){//found case
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    //reverse a LinkedList
    public void reverse(){ //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //LinkedList is pallindrome or not!
    // public boolean palindrome(){

    // }

    //Delete nth node from end FLIPKART IMP
    public void deleteNthFromEnd(int n){
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }   

        if(n==sz){
            head = head.next; //removeFirst()
        }

        int i = 1;
        int itofind = sz-n;
        Node prev = head;
        while(i<itofind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    //pallindrome LL
    //slow fast approach to find middleNode
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //slow is middle
    }

    public boolean checkPallindrome(){
        if(head==null || head.next == null){
            return true;
        }
        //mid
        Node midNode = findMid(head);

        //reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node rightHead = prev;
        Node leftHead = head;

        //check left and right half
        while(rightHead!=null){
            if(leftHead.data != rightHead.data){
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }

    //Cycle or Loop detection in LL FLOYD'S SLOW FAST CYCLE FINDING ALGO
    public static boolean isCycle(){
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        //detect cycle
        Node slow = head, fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                cycle = true;
                break;
            }
        }
        if(cycle==false){
            return;
        }

        //Find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //Remove cycle -> last.next = null
        prev.next = null;
    }

    //ZigZag Linked List
    public void ZigZag(){
        //finding mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;

        Node prev = null;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        //alternate merge - Zigzag merge
        while(left!=null && right!=null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }

    //Questions
    public static Node intersectionPoint(Node list1, Node list2){
        while(list2!=null){
            Node temp = list1;
            while(temp!=null){
                if(temp==list2){
                    return list2;
                }
                temp = temp.next;
            }
            list2 = list2.next;
        }
        return null;
    }

    public void print(){ //O(n)
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.add(2, 3);
        // ll.add(0, -9);
        // System.out.println(ll.removeFirst());
        // ll.removeLast();
        // ll.print();  
        // System.out.println(ll.size); 
        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(9));
        // ll.reverse();
        // ll.deleteNthFromEnd(3); 
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(5);
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(6);
        // ll.print();
        // ll.ZigZag();
        // ll.print();

        Node head1 ,head2;
        head1 = new Node(10);
        head2 = new Node(3);
        Node newNode = new Node(6);
        head2.next = newNode;
        newNode = new Node(9);
        head2.next.next = newNode;
        newNode = new Node(15);
        head1.next = newNode;
        head2.next.next.next = newNode;

        newNode = new Node(30);
        head1.next.next = newNode;
        head1.next.next.next = null;
        Node intersectionPoint = ll.intersectionPoint(head1, head2);
        if(intersectionPoint==null){
            System.out.println("NO INTERSECTION POINT");
        }else{
            System.out.print("Intersection Point: "+intersectionPoint.data);
        }
    }
}
