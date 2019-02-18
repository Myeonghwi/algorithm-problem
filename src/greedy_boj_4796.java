import java.util.*;

public class greedy_boj_4796 {
    static int L, P, V;
    static int cnt = 1;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            L = sc.nextInt();
            P = sc.nextInt();
            V = sc.nextInt();
            if (V == 0 && L == 0 && P == 0)
                break;
            System.out.println("Case "+ cnt + ": "+((V/P)*L+Math.min(L,V%P)));
            cnt ++;
        }
    }
}
