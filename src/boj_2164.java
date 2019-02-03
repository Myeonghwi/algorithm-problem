import java.util.*;

public class boj_2164 {

    static int front = 1;
    static int rear = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] Queue = new int[1001];
        int popNum = 0;

        rear = N;

        for (int i = 1; i <= N; i++)
            Queue[i] = i;

        pop(Queue);
        while(size() >= 1) {
            popNum = pop(Queue);
            push(Queue, popNum);
            pop(Queue);
        }
        System.out.println(Queue[rear]);
    }

    public static int pop(int[] Queue) {
        int popNum;
        popNum = Queue[front];
        front++;
        return popNum;
    }
    public static void push(int[] Queue, int popNum) {
        Queue[rear + 1] = popNum;
        rear++;
    }
    public static int size() {
        return rear - front;
    }
}
