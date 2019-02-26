import java.util.Scanner;


public class brute_boj_2503 {
    static int N;
    static int[][] arr;
    static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][5];

        int question;

        for (int i = 0; i < N; i++) {
            question = sc.nextInt();
            String number = String.valueOf(question);
            for (int j = 0; j < 3; j++) {
                arr[j][N] = number.charAt(j);
            }

            arr[3][N] = sc.nextInt();
            arr[4][N] = sc.nextInt();
        }

        Process(arr);
    }

    private static void Process(int[][] arr) {
        int[] candidate = new int[3];
        for (int i = 111; i < 999; i++) {
            String number = String.valueOf(i);
            for (int j = 0; j < number.length(); j++)
                candidate[j] = Character.digit(number.charAt(j), 10);

            for (int j = 0; j < N; j++) {

                int strike = 0;
                int ball = 0;

                if (arr[0][i] == candidate[0]) {
                    strike++;
                } else if (arr[0][i] == candidate[1] || arr[0][i] == candidate[2]) {
                    ball++;
                }

                if (arr[1][i] == candidate[1]) {
                    strike++;
                } else if (arr[1][i] == candidate[0] || arr[1][i] == candidate[2]) {
                    ball++;
                }

                if (arr[2][i] == candidate[2]) {
                    strike++;
                } else if (arr[2][i] == candidate[0] || arr[2][i] == candidate[1]) {
                    ball++;
                }

                if(arr[3][N] == strike && arr[4][N] == ball)
                    answer++;
            }
        }
        System.out.println(answer);
    }
}

