import java.util.*;

public class boj_10448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        int[] input_num = new int[testNum];
        int answer = 0;

        for(int i = 0; i < input_num.length; i++) {
            input_num[i] = sc.nextInt();
        }
        int[] triangleArr = new int[32];

        for(int n = 1; n <= 32; n++) {
            triangleArr[n - 1] = n * (n + 1) / 2;
        }
        for(int t = 0; t < input_num.length; t++) {
            answer = LogicFunction.doFunction(t, input_num, triangleArr);
            System.out.println(answer);
        }
    }
}

class LogicFunction{

    static int doFunction(int t, int[] input_num, int[] triangleArr){
        int answer = 0;
        // 3중 반복문에 대한 시간복잡도는 O(n3)
        // 경우의수가 많지않기 때문에 부담되지 않는다.
        for (int i = 0; i < triangleArr.length; i++) {
            for (int j = 1; j < triangleArr.length; j++) {
                for (int k = 2; k < triangleArr.length; k++) {
                    if (input_num[t] == triangleArr[i] + triangleArr[j] + triangleArr[k]) {
                        answer = 1;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
