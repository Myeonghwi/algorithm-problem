import java.util.*;

public class bfs_boj_6593 {
    static int L;
    static int R;
    static int C;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static char[][][] mat;
    static int[][][] visited;
    static Point end;
    static Point start;
    static Queue<Point> queue = new LinkedList<>();
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            if(L == 0 && R == 0 && C == 0)
                break;

            mat = new char[L + 1][R + 1][C + 1];
            visited = new int[L + 1][R + 1][C + 1];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = sc.next();
                    for (int k = 0; k < C; k++) {
                        mat[i][j][k] = str.charAt(k);
                        if (mat[i][j][k] == 'S') {
                            start = new Point(i, j, k);
                        }
                        if (mat[i][j][k] == 'E')
                            end = new Point(i, j, k);
                    }
                }
            }
            BFS();

            answer = visited[end.z][end.x][end.y];

            if (answer == 0)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in " + answer + " minute(s).");
        }
    }

    private static void BFS() {
        queue.add(start);

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L)
                    continue;
                if (mat[nz][nx][ny] == '#')
                    continue;
                if (visited[nz][nx][ny] != 0)
                    continue;

                queue.add(new Point(nz, nx, ny));
                visited[nz][nx][ny] = visited[cur.z][cur.x][cur.y] + 1;
            }
        }
    }

    public static class Point {
        int x, y, z;

        private Point(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}