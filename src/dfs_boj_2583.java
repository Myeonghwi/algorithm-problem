import java.util.*;

public class dfs_boj_2583 {

    static Scanner sc = new Scanner(System.in);
    static int M = sc.nextInt();
    static int N = sc.nextInt();
    static int K = sc.nextInt();
    static int[] point = new int[4];
    static int[][] mat;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;
    static ArrayList<Integer> answerList = new ArrayList<Integer>();


    public static void main(String[] args) {
        Input();
    }

    public static void Input() {
        mat = new int[M][N];
        for(int i = 0; i < K; i++) {
            for(int j = 0; j < 4; j++) {
                point[j] = sc.nextInt();
            }

            for(int x = point[0]; x < point[2]; x++) {
                for(int y = point[1]; y < point[3]; y++) {
                    mat[y][x] = 1;
                }
            }
        }
        Process();

//        Print(mat);
    }

    public static void Process() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    answer = 0;
                    DFS(i, j);
                    if (answer == 0) {
                        answer = 1;
                    }
                    answerList.add(answer);
                }
            }
        }
        Collections.sort(answerList);
        System.out.println(answerList.size());
        for(int i = 0; i < answerList.size(); i++)
            System.out.print(answerList.get(i) + " ");
    }

    public static void DFS(int x, int y) {
        // 동서남북 검사
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                continue;
            }
            if (mat[nx][ny] == 1) {
                continue;
            }

            mat[nx][ny] = 1;
            answer++;
            DFS(nx, ny);
        }
    }

    public static void Print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}