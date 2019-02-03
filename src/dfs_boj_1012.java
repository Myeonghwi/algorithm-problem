import java.util.Scanner;

public class dfs_boj_1012 {

    static Scanner sc = new Scanner(System.in);
    static int T = sc.nextInt();
    static int M;
    static int N;
    static int[][] mat;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) {
        Input();
    }

    public static void Input() {
        int x;
        int y;
        for (int i = 0; i < T; i++) {
            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();

            mat = new int[N][M];

            for (int j = 0; j < K; j++) {
                x = sc.nextInt();
                y = sc.nextInt();
                mat[y][x] = 1;
            }
            answer = 0;
            Process();
        }
    }

    public static void Process() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(mat[i][j] == 1) {
                    DFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void DFS(int x, int y) {
        // 동서남북 검사
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            if(mat[nx][ny] == 0) {
                continue;
            }

            mat[nx][ny] = 0;
            DFS(nx, ny);
        }
    }

    public static void Print(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
