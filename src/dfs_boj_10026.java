import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dfs_boj_10026 {

    static char[][] mat;
    static char[][] matWeakness;
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static char currentColor;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) {
        Input();
    }

    public static void Input() {
        mat = new char[N][N];
        matWeakness = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                mat[i][j] = str.charAt(j);
                matWeakness[i][j] = str.charAt(j);
            }
        }
        // 적록색약용 배열복사
        Process();
        ProcessWeakness();

//        Print(mat);
    }

    public static void Process() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] != 'X') {
                    currentColor = mat[i][j];
                    DFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void ProcessWeakness() {
        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matWeakness[i][j] != 'X') {
                    currentColor = matWeakness[i][j];
                    DFSWeakness(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }


    public static void DFS(int x, int y) {
        // 동서남북 검사
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if (mat[nx][ny] != currentColor) {
                continue;
            }

            mat[nx][ny] = 'X';
            DFS(nx, ny);
        }
    }

    public static void DFSWeakness(int x, int y) {
        // 색약용
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (currentColor == 'X')
                continue;

            else if (currentColor == 'B') {
                if (matWeakness[nx][ny] != 'B')
                    continue;
            }
            else if(currentColor == 'R' || currentColor == 'G') {
                if (matWeakness[nx][ny] == 'B')
                    continue;
            }

            mat[nx][ny] = 'X';
            DFS(nx, ny);
        }
    }

    public static void Print(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}