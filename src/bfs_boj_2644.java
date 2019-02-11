import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class bfs_boj_2644 {
    static private Scanner sc = new Scanner(System.in);
    static private int N = sc.nextInt();
    static private int person1 = sc.nextInt() - 1;
    static private int person2 = sc.nextInt() - 1;
    static private int M = sc.nextInt();
    static private int[][] adj = new int[N][N];
    static private int[] visited = new int[N];
    static private Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) {

        for (int i = 0; i < M; i++) {
            int parent = sc.nextInt() - 1;
            int child = sc.nextInt() - 1;

            adj[parent][child] = 1;
            adj[child][parent] = 1;
        }

        BFS(person1, person2);

        if (visited[person2] == 0)
            System.out.println("-1");

    }

    static private void BFS(int p1, int p2) {
        int level = 0;
        visited[p1] = 1;
        queue.add(p1);

        while (!queue.isEmpty()) {
            int queue_size = queue.size();

            for (int i = 0; i < queue_size; i++) {
                int curr = queue.poll();

                for (int j = 0; j < N; j++) {
                    if (adj[curr][j] == 1 && visited[j] == 0) {
                        visited[j] = 1;
                        queue.add(j);

                        if (j == p2) {
                            System.out.println(level + 1);
                        }
                    }
                }
            }
            level++;
        }
    }
}

