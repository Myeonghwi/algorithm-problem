import java.util.Scanner;


public class brute_boj_2503 {
    static int N;
    static int[][] mat;
    static int answer = 0;
    static int real_answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        mat = new int[5][N];

        int question;

        for (int i = 0; i < N; i++) {
            question = sc.nextInt();
            String number = String.valueOf(question);
            for (int j = 0; j < 3; j++) {
                mat[j][i] = Character.digit(number.charAt(j), 10);
            }

            mat[3][i] = sc.nextInt();
            mat[4][i] = sc.nextInt();
        }

        Process();
    }

    private static void Process() {
        int[] candidate = new int[3];
        for (int i = 111; i < 999; i++) {
            String number = String.valueOf(i);
            for (int j = 0; j < number.length(); j++)
                candidate[j] = Character.digit(number.charAt(j), 10);

            if(candidate[0] == candidate[1] || candidate[1] == candidate[2] || candidate[2] == candidate[0] || candidate[0] == 0 || candidate[1] == 0 || candidate[2] == 0)
                continue;

            for (int j = 0; j < N; j++) {

                int strike = 0;
                int ball = 0;

                if (mat[0][j] == candidate[0]) {
                    strike++;
                } else if (mat[0][j] == candidate[1] || mat[0][j] == candidate[2]) {
                    ball++;
                }

                if (mat[1][j] == candidate[1]) {
                    strike++;
                } else if (mat[1][j] == candidate[0] || mat[1][j] == candidate[2]) {
                    ball++;
                }

                if (mat[2][j] == candidate[2]) {
                    strike++;
                } else if (mat[2][j] == candidate[0] || mat[2][j] == candidate[1]) {
                    ball++;
                }

                if (mat[3][j] == strike && mat[4][j] == ball)
                    answer++;
            }
            if(answer >= N) {
                real_answer++;
            }
            answer = 0;
        }
        System.out.println(real_answer);
    }

}

