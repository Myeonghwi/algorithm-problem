import java.util.*;

public class greedy_boj_1449 {
    static int N, L;
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static int answer = 1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        N = sc.nextInt();
        L = sc.nextInt();

        for(int i = 0; i < N; i++)
            arr.add(sc.nextInt());

        Collections.sort(arr);

        int temp = arr.get(0);
        for(int i = 0; i < N; i++)
            if(temp + L - 1 < arr.get(i)) {
                temp = arr.get(i);
                answer++;
            }

        System.out.println(answer);
    }
}
