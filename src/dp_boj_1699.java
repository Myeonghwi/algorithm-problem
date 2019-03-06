import java.util.*;

public class dp_boj_1699 {
    public static void main(String[] args) {

        // 조온나 어렵다...
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dp[] = new int[N + 1];

//        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);


    }
}
