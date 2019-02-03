import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class boj_3986 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            char[] array = s.toCharArray();

            for (int j = 0; j < array.length; j++) {
                if (!stack.empty()) {
                    if (stack.peek() == array[j]) {
                        stack.pop();
                    } else {
                        stack.push(array[j]);
                    }
                } else {
                    stack.push(array[j]);
                }

            }
            if (stack.empty())
                answer++;
        }

        System.out.println(answer);
    }
}
