import java.util.*;

public class boj_9465 {
    public static void main(String[] args) {
        int[][] dp = new int[2][100001];
        int[][] sticker = new int[2][100001];

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int t = 0; t < testCase; t++) {
            int n = sc.nextInt();

            for (int i = 0; i <= 1; i++) {
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }
            dp[0][0] = dp[1][0] = 0;
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}

