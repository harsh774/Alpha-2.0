import java.util.*;

public class BinaryTreeB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // static class BinaryTree {
    // static int idx = -1;

    // public static Node buildTree(int nodes[]) {
    // idx++;
    // if (nodes[idx] == -1) {
    // return null;
    // }

    // Node newNode = new Node(nodes[idx]);
    // newNode.left = buildTree(nodes);
    // newNode.right = buildTree(nodes);

    // return newNode;
    // }

    // public static void preorder(Node root) {
    // if (root == null) {
    // return;
    // }
    // System.out.print(root.data);
    // preorder(root.left);
    // preorder(root.right);
    // }

    // public static void inorder(Node root) {
    // if (root == null) {
    // return;
    // }
    // inorder(root.left);
    // System.out.print(root.data + " ");
    // inorder(root.right);
    // }

    // public static void levelOrder(Node root) {
    // if (root == null) {
    // return;
    // }

    // Queue<Node> q = new LinkedList<>();
    // q.add(root);
    // q.add(null);

    // while (!q.isEmpty()) {
    // Node currNode = q.remove();
    // if (currNode == null) {
    // System.out.println();
    // if (q.isEmpty()) {
    // break;
    // } else {
    // q.add(null);
    // }
    // } else {
    // System.out.print(currNode.data + " ");
    // if (currNode.left != null) {
    // q.add(currNode.left);
    // }
    // if (currNode.right != null) {
    // q.add(currNode.right);
    // }
    // }
    // }
    // }

    // }

    // public static boolean isIdentical(Node node, Node subRoot) {
    // if (node == null && subRoot == null) {
    // return true;
    // } else if (node == null || subRoot == null || node.data != subRoot.data) {
    // return false;
    // }

    // if (!isIdentical(node.left, subRoot.left)) {
    // return false;
    // }
    // if (!isIdentical(node.right, subRoot.right)) {
    // return false;
    // }
    // return true;
    // }

    // public static boolean isSubtree(Node root, Node subRoot) {
    // if (root == null) {
    // return false;
    // }

    // if (root.data == subRoot.data) {
    // if (isIdentical(root, subRoot)) {
    // return true;
    // }
    // }

    // return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    // }
    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static void TopView(Node root) {
        // level order traversal
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void kLevelNodes(Node root, int level, int k) {
        if (k == level) {
            System.out.print(root.data + " ");
            return;
        }
        kLevelNodes(root.left, level + 1, k);
        kLevelNodes(root.right, level + 1, k);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean fuleft = getPath(root.left, n, path);
        boolean furight = getPath(root.right, n, path);

        if (fuleft || furight) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) { // O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lca = path1.get(i - 1);
        return lca;
    }

    public static boolean uniValued(Node root) {
        if (root == null)
            return true;
        if (root.left != null && root.data != root.left.data) {
            return false;
        }
        if (root.right != null && root.data != root.right.data) {
            return false;
        }
        return uniValued(root.left) && uniValued(root.right);

    }

    public static void main(String[] args) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.inorder(root);
        // tree.levelOrder(root);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);
        // subRoot.left.left = new Node(6);

        // System.out.println(isSubtree(root, subRoot));
        // TopView(root);
        // kLevelNodes(root, 1, 3);
        // System.out.println(lca(root, 4, 5).data);
        Node root2 = new Node(1);
        root2.left = new Node(1);
        root2.right = new Node(1);
        root2.left.left = new Node(1);
        root2.left.right = new Node(1);
        root2.right.right = new Node(1);
        System.out.println(uniValued(root2));

    }
}
