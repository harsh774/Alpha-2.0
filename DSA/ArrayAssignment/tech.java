package DSA.ArrayAssignment;

// import java.util.*;

// public class tech {
//     public static void rank(TreeSet<Integer> set, int ele) {
//         ArrayList<Integer> list = new ArrayList<>(set);
//         System.out.println(list.indexOf(ele) + 1);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int p = sc.nextInt();

//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }
//         int[] newarr = new int[p];
//         for (int i = 0; i < p; i++) {
//             newarr[i] = sc.nextInt();
//         }

//         TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

//         for (int i : arr) {
//             set.add(i);
//         }

//         for (int i : newarr) {
//             set.add(i);
//             rank(set, i);
//         }
//     }
// }

import java.util.*;

public class tech {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        for (int i : arr) {
            set.add(i);
        }

        int rank = 1;
        for (int num : set) {
            rankMap.put(num, rank++);
        }

        for (int i = 0; i < p; i++) {
            int newElement = sc.nextInt();
            set.add(newElement);
            System.out.println(rankMap.get(newElement));
        }
    }
}
