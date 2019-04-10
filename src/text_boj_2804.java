import java.util.*;

public class text_boj_2804 {
    static String inputWord;
    static String wordA;
    static String wordB;

    static int locA, locB;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inputWord = sc.nextLine();
        wordA = inputWord.split(" ")[0];
        wordB = inputWord.split(" ")[1];
        char[] splitWordA = new char[wordA.length()];
        char[] splitWordB = new char[wordB.length()];

        for(int i = 0; i < splitWordA.length; i++)
            splitWordA[i] = (wordA.charAt(i));
        for(int i = 0; i < splitWordB.length; i++)
            splitWordB[i] = (wordB.charAt(i));

        outerloop:
        for(int i = 0; i < splitWordA.length; i++) {
            for(int j = 0; j < splitWordB.length; j++) {
                if (splitWordA[i] == splitWordB[j]) {
                    locA = i;
                    locB = j;
                    break outerloop;
                }
            }
        }

        for(int i = 0; i < splitWordB.length; i++) {
            for(int j = 0; j < splitWordA.length; j++) {
                if (i == locB) {
                    System.out.print(splitWordA[j]);
                    continue;
                }

                if (j != locA)
                    System.out.print('.');
                else
                    System.out.print(splitWordB[i]);

            }
            System.out.println();
        }

    }
}