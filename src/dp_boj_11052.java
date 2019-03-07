import java.util.*;

public class dp_boj_11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int p[] = new int[1001];
        int dp[] = new int[1001];

        dp[0] = 0;

        for (int i = 1; i <= N; i++)
            p[i] = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
            }
        }

        System.out.println(dp[N]);


    }
}
