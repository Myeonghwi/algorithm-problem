import java.util.Scanner;
import java.util.Stack;

public class boj_2841 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int answer = 0;
        Stack<Integer>[] stack = new Stack[N];

        for (int i = 0; i < N; i++)
            stack[i] = new Stack<Integer>();

        for (int i = 0; i < N; i++) {
            int line = sc.nextInt();
            int n = sc.nextInt();

            if (stack[line].empty()) {
                stack[line].push(n);
                answer++;
            } else {
                while (true) {
                    if (stack[line].empty()) {
                        stack[line].push(n);
                        answer++;
                        break;
                    }
                    else if (stack[line].peek() > n) {
                        stack[line].pop();
                        answer++;
                    }
                    else if(stack[line].peek() == n){
                        break;
                    }
                    else {
                        stack[line].push(n);
                        answer++;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
