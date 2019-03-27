import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
import java.util.PriorityQueue;

public class greedy_boj_11000 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();

        ClassRoom[] arr = new ClassRoom[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            arr[i] = new ClassRoom(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(arr, ClassRoom.comparator);
        pq.add(arr[0].end);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i].start) {
                pq.poll();
            }
            pq.add(arr[i].end);
        }
        System.out.println(pq.size());
    }

    public static class ClassRoom {
        int start;
        int end;

        private ClassRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        static Comparator<ClassRoom> comparator = new Comparator<ClassRoom>() {
            @Override
            public int compare(ClassRoom o1, ClassRoom o2) {
                if (o1.start == o2.start)
                    return Integer.compare(o1.end, o2.end);
                else
                    return Integer.compare(o1.start, o2.start);
            }
        };

    }
}