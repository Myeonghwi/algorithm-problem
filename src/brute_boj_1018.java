import java.util.Scanner;

public class brute_boj_1018 {
    static int N, M;
    static int BOUND = 8;
    static char[][] mat;
    static int minChange = 1000;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        mat = new char[N][M];
        for (int i = 0; i < N; i++) {
            String t = sc.next();
            for (int j = 0; j < M; j++)
                mat[i][j] = t.charAt(j);
        }
//        Print();
        Process();
    }

    private static void Process() {
        for (int i = 0; i <= N - (BOUND - 1); i++)
            for (int j = 0; j <= M - (BOUND - 1); j++)
                minChange = Math.min(minChange, _Search(i, j));
        System.out.print(minChange);
    }

    private static int _Search(int x, int y) {
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = x; i < x + BOUND; i++) {
            for (int j = y; j < y + BOUND; j++) {
                char cp = ((i + j) % 2 == 0) ? 'W' : 'B';
                if (mat[i][j] != cp)
                    cnt1++;
                else
                    cnt2++;
            }
        }
        if(cnt1 > cnt2)
            answer = cnt2;
        else
            answer = cnt1;

        return answer;
    }

    private static void Print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
