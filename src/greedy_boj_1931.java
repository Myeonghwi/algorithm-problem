import java.util.Scanner;

public class greedy_boj_1931 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int[][] arr = new int[N][2];
    static int answer = 0;
    static int end = 0;
    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // 종료시간에 따라 sort
        for (int i = 0; i < N; i++) {
            //현재 시작시간이 이전 종료시간보다 늦을 경우
            if (arr[i][0] >= end) {
                end = arr[i][1];    //현재 종료시간을 다음 시작시간과 비교하기위해 저장
                answer++;
            }
        }
        System.out.println(answer);
    }
}
