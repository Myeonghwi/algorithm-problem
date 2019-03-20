import java.util.*;

public class bfs_boj_5427 {
    static private int T;
    static private int w;
    static private int h;
    static private char mat[][];
    static private int exit;
    static private int answer;
    static private int dx[] = {-1, 0, 1, 0};
    static private int dy[] = {0, 1, 0, -1};
    static private Queue<Point> person = new LinkedList<Point>();
    static private Queue<FirePoint> fire = new LinkedList<FirePoint>();

    public static void main(String[] args) {
        Input();
    }

    public static void Input() {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            exit = 0;
            w = sc.nextInt();
            h = sc.nextInt();
            mat = new char[h][w];

            for(int y = 0; y < h; y++) {
                String str = sc.next();
                for(int x = 0; x < w; x++) {
                    // 사람 시작 위치
                    if (str.charAt(x) == '@')
                        person.add(new Point(y, x, 0));
                    // 불난곳
                    if (str.charAt(x) == '*')
                        fire.add(new FirePoint(y, x));

                    mat[y][x] = str.charAt(x);
                }
            }
            BFS();
        }
    }

    public static void Print() {
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println(" ");
        }
    }

    public static void BFS() {

        while(true) {
            int answer = 0;
            int fireSize = fire.size();
            for(int f = 0; f < fireSize; f++) {
                int qx = fire.peek().x;
                int qy = fire.peek().y;
                fire.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = qx + dx[i];
                    int ny = qy + dy[i];

                    if (nx < 0 || ny < 0 || nx >= w || ny >= h)
                        continue;
                    if (mat[ny][nx] == '.' || mat[ny][qx] == '@') {
                        mat[ny][nx] = '*';
                        fire.add(new FirePoint(ny, nx));
                    }
                }
            }

            int personSize = person.size();
            for(int p = 0; p < personSize; p++) {
                int qx = person.peek().x;
                int qy = person.peek().y;
                answer = person.peek().answer;
                person.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = qx + dx[i];
                    int ny = qy + dy[i];

                    if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                        // 탈출
                        exit = 1;
                        break;
                    }
                    if (mat[ny][nx] == '.') {
                        mat[ny][nx] = '@';
                        person.add(new Point(ny, nx, answer + 1));
                    }
                }
            }

            if (exit == 1) {
                System.out.println(++answer);
                while (!fire.isEmpty()) fire.poll();
                while (!person.isEmpty()) person.poll();
                break;
            }
            if(person.isEmpty()){
                while (!fire.isEmpty())fire.poll();
                while (!person.isEmpty())person.poll();
                System.out.println("IMPOSSIBLE");
                break;
            }
        }
    }


    public static class FirePoint {
        int x, y;

        private FirePoint(int y, int x){
            this.y = y;
            this.x = x;
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
}
