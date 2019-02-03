import java.util.Scanner;
import java.util.Stack;

public class boj_11724 {
    static int MAX = 10001;
    static Scanner sc = new Scanner(System.in);
    static private int N = sc.nextInt();
    static private int M = sc.nextInt();
    static private Stack<Integer>[] stack = new Stack[MAX];
    static private boolean[] visited = new boolean[MAX];

    public static void main(String[] args) {
        for(int i = 0; i < MAX; i++)
            stack[i] = new Stack<Integer>();

        for(int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdge(u, v);
        }

        int answer = 0;

        for(int i = 0; i <= N; i++) {
            if(!visited[i]) {
                DFS(i);
                answer++;
            }
        }

        System.out.println(answer - 1);

    }

    static private void addEdge(int u, int v) {
        stack[u].push(v);
        stack[v].push(u);
    }

    static private void DFS(int node) {
        visited[node] = true;

        for(int i = 0; i < stack[node].size(); i++) {
            int next = stack[node].get(i);

            if(!visited[next])
                DFS(next);
        }
    }
}
