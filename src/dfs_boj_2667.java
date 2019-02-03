import java.util.*;

public class dfs_boj_2667 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int[][] mat = new int[N][N];
    static String element = sc.nextLine();
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int danjiCount = 0;
    static ArrayList<Integer> answer = new ArrayList<Integer>();

    public static void main(String[] args) {
        Input();
        Process();
        answerPrint();
    }

    public static void Input() {
        for (int i = 0; i < N; i++) {
            element = sc.nextLine();
            String arr[] = element.split("");
            for (int j = 0; j < N; j++) {
                mat[i][j] = Integer.parseInt(arr[j]);
            }
        }
    }

    public static void Process() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                if(mat[i][j] == 1) {
                    DFS(i, j);
                    if(danjiCount == 0)
                        danjiCount = 1;
                    answer.add(danjiCount);
                    danjiCount = 0;
                }
            }
        }
    }

    public static void DFS(int x, int y) {
        // 동서남북 검사
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if(mat[nx][ny] == 0) {
                continue;
            }

            danjiCount++;
            mat[nx][ny] = 0;
            DFS(nx, ny);
        }
    }

    public static void Print() {
        for(int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void answerPrint() {
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i = 0; i < answer.size(); i++)
            System.out.println(answer.get(i));
    }
}