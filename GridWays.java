public class GridWays {
    public static int gridways(int i, int j, int n, int m){
        //base case
        if(i==n-1 && j==m-1){
            return 1;
        }else if(i==n || j==m){
            return 0;
        }
        
        int w1 = gridways(i+1, j, n, m);
        int w2 = gridways(i, j+1, n, m);
        return w1+w2;
    }
    public static long fact(int n) {
        if (n <= 2) {
            return n;
        }
        return n * fact(n - 1);
    }

    public static int permutaionGridWays(int m, int n){
        int ans = (int)( fact((m-1)+(n-1))/fact(m-1)*fact(n-1));
        return ans;
    }
    public static void main(String[] args) {
        int n=3,m=3;
        // System.out.println(gridways(0,0,n,m));
        System.out.println(permutaionGridWays(m, n));
    }
}
