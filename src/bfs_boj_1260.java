import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class bfs_boj_1260 {
    static int MAX = 1001;
    static Scanner sc = new Scanner(System.in);
    static private int N = sc.nextInt();
    static private int M = sc.nextInt();
    static private int V = sc.nextInt();
    static private int[][] mat = new int[MAX][MAX];
    static private Queue<Integer> queue = new LinkedList<Integer>();
    static private boolean[] visited = new boolean[MAX];

    public static void main(String[] args) {
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            mat[u][v] = mat[v][u] = 1;

        }
        for (int i = 0; i <= N; i++) {
            if (mat[V][i] == 1 && !visited[V]) {
                DFS(V);
            }
        }

        System.out.println();
        visited = new boolean[MAX];

        BFS();

    }

    static private void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;

        for (int i = 1; i <= N; i++) {
            if (mat[node][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }

    }

    static private void BFS() {
        int out;
        queue.add(V);
        visited[V] = true;
        System.out.print(V + " ");

        while (!queue.isEmpty()) {

            out = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (mat[out][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    System.out.print(i + " ");
                }
            }
        }

    }
}
