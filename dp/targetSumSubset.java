package dp;

public class targetSumSubset {
    public static void main(String[] args) {
        int[] num = { 4, 2, 7, 1, 3 };
        int targetSum = 10;

        // tabulation
        System.out.println(knapSackApproach(num, targetSum));
    }

    private static boolean knapSackApproach(int[] num, int sum) {
        int n = num.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int number = num[i - 1];

                // valid & include
                if (number <= j && dp[i - 1][j - number]) {
                    dp[i][j] = true;
                }
                // exclude or invalid
                else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][sum];
    }
}
