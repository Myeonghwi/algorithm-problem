import java.util.Scanner;

public class dfs_boj_11403 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int[][] mat;
    static int[][] answer;


    public static void main(String[] args) {
        Input();
        Process();
        AnswerPrint(answer);
    }

    public static void Input() {
        mat = new int[N + 1][N + 1];
        answer = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }

    public static void Process() {
        for (int i = 1; i <= N; i++) {
            int[] visited = new int[N + 1];
            DFS(i, visited, true);
            answer[i] = visited;
        }
    }

    static void DFS(int i, int[] visited, boolean isFirst) {
        if (!isFirst)
            visited[i] = 1;
        for (int j = 1; j <= N; j++) {
            // 간선간 이동이 가능하며, 방문 X
            if (mat[i][j] == 1 && visited[j] == 0) {
                DFS(j, visited, false);
            }
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

    public static void AnswerPrint(int[][] answer) {
        for (int i = 1; i < answer.length; i++) {
            for (int j = 1; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}

