import java.util.ArrayList;
import java.util.Scanner;

public class greedy_boj_11047 {
    static int N, K;
    static int answer = 0;
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();

        for(int i = 0; i < N; i++)
            arr.add(sc.nextInt());

        for(int i  = N - 1; i >= 0; i--) {
            if(arr.get(i) > K)
                continue;
            else {
                answer += K / arr.get(i);
                K = K % arr.get(i);

            }
        }

        System.out.println(answer);

    }
}
