import java.util.*;

public class boj_2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int coin[] = new int[N + 1];
        int dp[] = new int[K + 1];

        Arrays.fill(dp,100001);
        dp[0] = 0;

        for(int i = 1; i <= N; i++)
            coin[i] = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            for(int j = coin[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        System.out.println(dp[K]);


    }
}
