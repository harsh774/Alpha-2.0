import java.util.*;

public class bst {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) { // O(H)
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // case1 leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case2 one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case3 both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPathtoLeaf(ArrayList<Integer> path) {
        for (int i : path) {
            System.out.print(i + "->");
        }
        System.out.println("Null");
    }

    public static void printPath(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPathtoLeaf(path);
        }
        printPath(root.left, path);
        printPath(root.right, path);
        path.remove(path.size() - 1);

    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null)
            return true;

        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        int val[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        // int val[] = {1,1,1};
        Node root = null;
        for (int i : val) {
            root = insert(root, i);
        }

        // inorder(root);
        // System.out.println();

        // System.out.println(search(root, 10));
        // System.out.println(search(root, 12));

        // root = delete(root, 5);
        // System.out.println();
        // inorder(root);

        // printInRange(root, 0, 11);
        // printPath(root, new ArrayList<>());
        // if(isValidBST(root, null, null)){
        // System.out.println("Valid");
        // }else{
        // System.out.println("Not Valid");
        // }
    }
}
