import java.util.Scanner;

public class brute_boj_1018 {
    static int N, M;
    static int BOUND = 8;
    static char[][] mat;
    static int numberOfChange = 0;
    static int minChange = 100;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        mat = new char[N][M];
        for (int i = 0; i < N; i++) {
            String t = sc.next();
            for (int j = 0; j < M; j++)
                mat[i][j] = t.charAt(j);
        }
//        Print();
        Process();
    }

    private static void Process() {
        for (int i = 0; i <= N - BOUND; i++)
            for (int j = 0; j <= M - BOUND; j++)
                minChange = Math.min(minChange, _Search(i, j));
        System.out.print(minChange);
    }

    private static int _Search(int x, int y) {
        numberOfChange = 0;
        char initColor = mat[x][y];
        char currentColor;
        char nextColor;
        int newLineCorrect = 1;

        for (int i = x; i < BOUND; i++) {
            // 첫줄 시작이 아닐 경우
            if (i != x) {
                initColor = _nextColor(initColor);
                if (initColor != mat[i][0]) {
                    newLineCorrect = 0;
                }
            }

            for (int j = y; j < BOUND; j++) {
                if (newLineCorrect == 1) {
                    currentColor = mat[i][j];
                    nextColor = _nextColor(currentColor);
                    if (currentColor == nextColor) {
                        // 틀린부분
                        // 다음색을 바꿔줄 필요 X
                        numberOfChange++;
                        nextColor = _nextColor(currentColor);
                    }
                }
            }
        }
        return numberOfChange;
    }

    private static char _nextColor(char beforeColor) {
        if (beforeColor == 'W')
            return 'B';
        else
            return 'W';
    }

    private static void Print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
