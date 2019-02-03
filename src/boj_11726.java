import java.util.*;

public class boj_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d[] = new long[n + 1];
        d[0] = 1;
        d[1] = 1;

        for(int i = 2; i <= n; i++) {
            d[i] = (d[i - 2] + d[i - 1]) % 10007;
        }
        System.out.println(d[n]);
    }
}
