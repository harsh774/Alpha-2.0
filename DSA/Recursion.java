package DSA;

public class Recursion {

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length - 1) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i + 1);
    }

    public static int lastOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccurence(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int tilingProblem(int n) {
        // base case
        if (n < 2) {
            return 1;
        }

        // Work
        int fnm1 = tilingProblem(n - 1);
        int fnm2 = tilingProblem(n - 2);
        return fnm1 + fnm2;
    }

    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean[] map) {
        // base case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        // work
        char currentChar = str.charAt(idx);
        if (map[currentChar - 'a'] == true) {
            //duplicate item
            removeDuplicate(str, idx+1, newStr, map);
        }else{
            map[currentChar-'a']=true;
            removeDuplicate(str, idx+1, newStr.append(currentChar), map);
        }
    }

    public static int friendPairing(int n){
        //base case
        if(n==1||n==2){
            return n;
        }

        //choice
        //Single
        int fnm1 = friendPairing(n-1);

        //pair
        int fnm2 = friendPairing(n-2);
        int pairWays = (n-1)*fnm2;

        //totalways
        int totways = fnm1+pairWays;
        return totways;
    }

    public static void indexNumberofKey(int[] arr, int idx, int key){
        //base case
        if(idx==arr.length){
            return;
        }

        //work
        if(arr[idx]!=key){
            indexNumberofKey(arr, idx+1, key);
        }else{
            System.out.print(idx+" ");
            indexNumberofKey(arr, idx+1, key);
        }
    }

    public static void main(String[] args) {
        // int arr[] = {8,3,6,9,5,10,2,5,3};
        // // System.out.println(isSorted(arr, 0));
        // System.out.println(lastOccurence(arr, 5, 0));

        // System.out.println(tilingProblem(5));

        // String str = "appnnacollege";
        // removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(friendPairing(3));
        int[] arr = {3,2,4,5,6,2,7,2,2};
        indexNumberofKey(arr, 0, 2);
    }
}
