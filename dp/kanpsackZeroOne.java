package dp;

public class kanpsackZeroOne {

    // O(2^n)
    public static int knapSack(int[] val, int[] wt, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapSack(val, wt, W - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapSack(val, wt, W, n - 1);

            return Math.max(ans1, ans2);
        } else {
            // exclude
            return knapSack(val, wt, W, n - 1);
        }
    }

    // O(n*W)
    public static int knapSack2(int[] val, int[] wt, int W, int n, int[][] dp) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapSack2(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapSack2(val, wt, W, n - 1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            // exclude
            dp[n][W] = knapSack2(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    // tabulation
    public static int knapSack3(int[] val, int[] wt, int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];

                // valid
                if (w <= j) {
                    // include
                    int inProfit = v + dp[i - 1][j - w];
                    // exclude
                    int exProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(inProfit, exProfit);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

    public static void print(int[][] dp) {
        for (int[] i : dp) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int weight = 7;

        // recursion approach
        System.out.println(knapSack(val, wt, weight, val.length));

        int[][] dp = new int[val.length + 1][weight + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // memoization
        System.out.println(knapSack2(val, wt, weight, val.length, dp));

        // tabulation
        System.out.println(knapSack3(val, wt, weight));
    }
}
