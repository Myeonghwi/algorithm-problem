import java.util.Scanner;
import java.util.ArrayList;

public class greedy_boj_1700 {
    static Scanner sc = new Scanner(System.in);
    static int priorityMat[];
    static ArrayList<Integer> multiTab = new ArrayList<Integer>();
    static int distributionMat[];
    static int answer = 0;
    static int trigger = 0;
    static int p;
    static int unpluged;
    static int minUse = 100000;

    public static void main(String[] args) {
        int N = sc.nextInt();
        int K = sc.nextInt();

        priorityMat = new int[K];
        distributionMat = new int[101];

        for (int i = 0; i < K; i++) {
            int input = sc.nextInt();
            priorityMat[i] = input;
            distributionMat[input]++;
        }


        for (int i = 0; i < K; i++) {
            // 멀티탭이 비어있으면
            if(multiTab.size() < N) {
                multiTab.add(priorityMat[i]);
                continue;
            }
            p = priorityMat[i];
            minUse = 100000;
            // 이미 플러그가 꽂혀있으면 그냥 지나친다
            for (int j = 0; j < N; j++) {
                if (multiTab.get(j) == p) {
                    trigger = 1;
                    distributionMat[p]--;
                    break;
                }
            }
            if (trigger == 1) {
                trigger = 0;
                continue;
            }

            if (multiTab.size() == N) {
                // 플러그가 모두 꽉찼다면
                for (int j = 0; j < N; j++) {
                    // 앞으로 사용이 안될 요소 찾기
                    if (minUse > distributionMat[multiTab.get(j)]) {
                        minUse = distributionMat[multiTab.get(j)];
                        unpluged = j;
                    }
                }

                multiTab.remove(unpluged);
                multiTab.add(priorityMat[i]);
                distributionMat[p]--;
                answer++;

            } else {
                multiTab.add(priorityMat[i]);
                distributionMat[p]--;
            }

        }
        System.out.println(answer);
    }
}