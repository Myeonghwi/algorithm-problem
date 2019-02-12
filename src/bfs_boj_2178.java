import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 미로탐색
public class bfs_boj_2178 {
    static int N, M;
    static int[][] mat;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static private Queue<Point> queue = new LinkedList<Point>();
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        mat = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                mat[i][j] = line.charAt(j) - '0';
                visited[i][j] = false;
            }
        }
//        Print(mat);
        Process();
    }

    private static void Process() {
        BFS(0, 0);
    }

    private static void BFS(int x, int y) {
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            y = queue.peek().y;
            x = queue.peek().x;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (mat[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    mat[nx][ny] = mat[x][y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println(mat[N - 1][M - 1]);
    }

    private static void Print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println(" ");
        }
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

