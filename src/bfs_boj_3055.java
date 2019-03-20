import java.util.*;

public class bfs_boj_3055 {
    static private int R;
    static private int C;
    static private char mat[][];
    static private int exit;
    static private int dx[] = {-1, 0, 1, 0};
    static private int dy[] = {0, 1, 0, -1};
    static private Queue<Point> hedgehog = new LinkedList<Point>();
    static private Queue<WaterPoint> water = new LinkedList<WaterPoint>();

    public static void main(String[] args) {
        Input();
    }

    public static void Input() {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        mat = new char[R][C];

        for (int y = 0; y < R; y++) {
            String str = sc.next();
            for (int x = 0; x < C; x++) {
                // 고슴도치 시작 위치
                if (str.charAt(x) == 'S')
                    hedgehog.add(new Point(y, x, 0));
                // 물찬곳
                if (str.charAt(x) == '*')
                    water.add(new WaterPoint(y, x));
                mat[y][x] = str.charAt(x);
            }
        }
        BFS();
//        Print();
    }

    public static void Print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println(" ");
        }
    }

    public static void BFS() {

        while (true) {
            int answer = 0;
            int waterSize = water.size();
            for (int f = 0; f < waterSize; f++) {
                int qx = water.peek().x;
                int qy = water.peek().y;
                water.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = qx + dx[i];
                    int ny = qy + dy[i];

                    if (nx < 0 || ny < 0 || nx >= C || ny >= R)
                        continue;
                    if (mat[ny][nx] == '.' || mat[ny][qx] == 'S') {
                        mat[ny][nx] = '*';
                        water.add(new WaterPoint(ny, nx));
                    }
                }
            }

            int hedgehogSize = hedgehog.size();
            for (int p = 0; p < hedgehogSize; p++) {
                int qx = hedgehog.peek().x;
                int qy = hedgehog.peek().y;
                answer = hedgehog.peek().answer;
                hedgehog.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = qx + dx[i];
                    int ny = qy + dy[i];

                    if (nx < 0 || ny < 0 || nx >= C || ny >= R)
                        continue;
                    if (mat[ny][nx] == 'D') {
                        exit = 1;
                        break;
                    }
                    if (mat[ny][nx] == '.') {
                        mat[ny][nx] = 'S';
                        hedgehog.add(new Point(ny, nx, answer + 1));
                    }
                }
            }

            if (exit == 1) {
                System.out.println(++answer);
                while (!water.isEmpty()) water.poll();
                while (!hedgehog.isEmpty()) hedgehog.poll();
                break;
            }
            if (hedgehog.isEmpty()) {
                while (!water.isEmpty()) water.poll();
                while (!hedgehog.isEmpty()) hedgehog.poll();
                System.out.println("KAKTUS");
                break;
            }
        }
    }

    public static class Point {
        int x, y, answer;

        private Point(int y, int x, int answer) {
            this.y = y;
            this.x = x;
            this.answer = answer;
        }
    }

    public static class WaterPoint {
        int x, y;

        private WaterPoint(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
