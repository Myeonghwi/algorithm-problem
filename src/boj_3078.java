import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Deque;


public class boj_3078 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = sc.nextInt();
        int K = sc.nextInt();
        String name;

        Deque<String> deque = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            name = br.readLine();
            deque.addLast(name);
        }

        int answer = 0;

        while(!deque.isEmpty()) {
            for(int i = 0; i < deque.size(); i++) {
                if(i > K)
                    break;
                if(deque.getFirst().length() == ((LinkedList<String>) deque).get(i).length()) {
                    answer++;
                }
            }
            deque.removeFirst();
        }
        System.out.println(answer);
    }
}
