import java.util.*;

public class BSTtoBalancedBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    public static Node balancedBST(Node root) { // O(n)
        // inorder sequence of BST - O(n)
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder -> balanced BST - O(n)
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;

    }

    // Largest BST Size..
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }

    }

    public static int maxBST = 0;

    public static Info longestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = longestBST(root.left);
        Info rightInfo = longestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.right = new Node(10);
        // root.left.left = new Node(5);
        // root.right.right = new Node(11);
        // root.left.left.left = new Node(3);
        // root.right.right.right = new Node(12);

        // root = balancedBST(root);
        // preOrder(root);

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info info = longestBST(root);
        System.out.println("Largest BST size: " + maxBST);

    }
}
