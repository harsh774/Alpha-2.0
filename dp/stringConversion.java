package dp;

public class stringConversion {
    public static void minOperations(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int lcs = lcs(s1, s2);
        System.out.println("Number of Insertion Operation: " + (m - lcs));
        System.out.println("Number of Deletion Operations: " + (n - lcs));
    }

    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";
        minOperations(str1, str2);
    }
}
