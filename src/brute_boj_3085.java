import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class brute_boj_3085 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char temp;

        char[][] arr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[n][n];
        try {
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().toCharArray();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                // SWAP
                // OutOfIndex오류를 줄이기 위해 행부터 시작
                temp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = temp;

                // 최대값 찾기
                // 빈도수 구하기
//                for (int k = 0; k < arr.length; k++) {
//                    for (int l = 0; l < arr.length; l++) {
//                        arr[k][l];
//                    }
//                }
                // 되돌리기
                temp = arr[i][j + 1];
                arr[i][j + 1] = arr[i][j];
                arr[i][j] = temp;

                ///////////////////////////////////////////////////////
                temp = arr[i][j];
                arr[i][j] = arr[i + 1][j];
                arr[i + 1][j] = temp;

                // 최대값 찾기
                // 빈도수 구하기
//                for (int k = 0; k < arr.length; k++) {
//                    for (int l = 0; l < arr.length; l++) {
//                        arr[k][l];
//                    }
//                }
                temp = arr[i + 1][j];
                arr[i][j] = arr[i][j + 1];
                arr[i + 1][j] = temp;

            }
        }
    }
}
