import java.util.*;

public class dfs_boj_1743 {

    static Scanner sc = new Scanner(System.in);
    static int M;
    static int N;
    static int K;
    static int[][] mat;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int answer = 0;
    static int pre = 0;

    public static void main(String[] args) {
        Input();
    }

    public static void Input() {
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        mat = new int[N][M];
        int x, y;
        for(int i = 0; i < K; i++) {
            y = sc.nextInt();
            x = sc.nextInt();
            mat[y - 1][x - 1] = 1;
        }
        Process();
    }

    public static void Process() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                answer = 0;
                if(mat[i][j] == 1) {
                    DFS(i, j);
                    if(answer > pre)
                        pre = answer;
                }
            }
        }
        System.out.println(pre);
    }


    public static void DFS(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            if(mat[nx][ny] == 0) {
                continue;
            }
            answer++;
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
