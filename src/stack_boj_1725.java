import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.Collections;

public class stack_boj_1725 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> Answer = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int H = sc.nextInt();
            int last = 0;
            int width = 0;

            if (stack.empty()) {
                stack.push(H);
            } else {
                while (true) {
                    if (!stack.empty() && stack.peek() <= H) {
                        stack.pop();
                        width++;
                    } else {
                        Answer.add(width * last);
                        break;
                    }
                }
            }
        }

        int width = 0;
        int last = 0;
        while(!stack.empty()) {
            last = stack.peek();
            stack.pop();
            width++;
        }
        Answer.add(width * last);

        Collections.sort(Answer);
        System.out.println(Answer.get(0));
    }
}
