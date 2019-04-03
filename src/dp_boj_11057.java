import java.util.*;

public class dp_boj_11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long dp[][] = new long[10001][10];

        for (int i = 0; i <= 9; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[N][i];
        }
        System.out.println(answer % 10007);


    }
}