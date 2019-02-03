import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1966 {
    static StringTokenizer str;
    static int front = 0;
    static int rear = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = sc.nextInt();
        int[] Queue = new int[101];
        int[] SortQueue = new int[101];
        int[] check = new int[101];

        for(int i = 0; i < T; i++) {
            str = new StringTokenizer(br.readLine());
        }
        str.nextToken();
        // 중요도를 체크하는 정렬된 큐
        Arrays.sort(SortQueue);
        int M = sc.nextInt();
        int answer = 0;
        int idx = 0;
        check[M] = 1;

        while(true) {
            int popNum = 0;
            if(check[0] == 1) {
                System.out.println(answer);
                break;
            }
            if(Queue[front] < SortQueue[idx]) {
                popNum = pop(Queue);
                push(Queue, popNum);
                popNum = pop(check);
                push(check, popNum);
            }
            else if(Queue[front] >= SortQueue[idx]) {
                idx++;
                answer++;
            }
        }
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
}
