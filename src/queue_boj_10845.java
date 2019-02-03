import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class queue_boj_10845 {

    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = sc.nextInt();
        int[] Queue = new int[10001];
        List<Integer> Answer = new ArrayList<>();

        int rear = 0;
        int front = 0;

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            switch(str.nextToken()) {
                case "push":
                    Queue[rear] = Integer.parseInt(str.nextToken());
                    rear++;
                    break;
                case "pop":
                    if(front >= rear)
                        Answer.add(-1);
                    else {
                        Answer.add(Queue[front]);
                        front++;
                    }
                    break;
                case "size":
                    Answer.add(rear - front);
                    break;
                case "empty":
                    if(front >= rear)
                        Answer.add(1);
                    else
                        Answer.add(0);
                    break;
                case "front":
                    if(front >= rear)
                        Answer.add(-1);
                    else
                        Answer.add(Queue[front]);
                    break;
                case "back":
                    if(front >= rear)
                        Answer.add(-1);
                    else
                        Answer.add(Queue[rear - 1]);
                    break;
            }
        }
        for(int i = 0; i < Answer.size(); i++) {
            System.out.println(Answer.get(i));
        }
    }
}
