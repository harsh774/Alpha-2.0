package bianary_tree;
public class mirrorBST {
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static Node createMirror(Node root){ //O(n)
        if(root == null){
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void preOrder(Node root){
        if(root == null) return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //SOrted array to Balanced BST
    public static Node createBST(int[] arr, int st, int end){
        if(st>end) return null;
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }
    public static void main(String[] args) {
        
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        
        // createMirror(root);
        // preOrder(root);

        int arr[] = {3,5,6,8,10,11,12};
        Node root2 = createBST(arr, 0, arr.length-1);
        preOrder(root2);
    }
}
