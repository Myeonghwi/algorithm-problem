import java.util.*;

public class text_boj_9996 {
    static int N;
    static int cnt;
    static String pattern;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        pattern = sc.nextLine();
//        char[] splitPattern = new char[pattern.length()];

        String[] inputWord = new String[N];

        for(int i = 0; i < N; i++) {
            inputWord[i] = sc.nextLine();
        }

//        for(int i = 0; i < splitPattern.length; i++)
//            splitPattern[i] = (pattern.charAt(i));

//        char start = splitPattern[0];
//        char end = splitPattern[splitPattern.length - 1];
        String[] splitPattern = pattern.split("\\*");

        for(int i = 0; i < N; i++) {
            cnt = 0;
            for(int j = 0; j < 2; j++) {
                if (inputWord[i].startsWith(splitPattern[0]) && j == 0) {
                    inputWord[i] = inputWord[i].replaceFirst(splitPattern[0], "");
                    cnt++;
                }
                else if (inputWord[i].contains(splitPattern[1]) && j == 1) {
                    cnt++;
                }
            }
            if(cnt == 2) {
                System.out.println("DA");
            }
            else {
                System.out.println("NE");
            }
        }
    }
}