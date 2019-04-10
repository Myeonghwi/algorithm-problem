import java.util.*;

public class text_boj_2810 {
    static int numberOfSeat;
    static String seat;
    static float answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numberOfSeat = sc.nextInt();
        sc.nextLine();
        seat = sc.nextLine();
        char[] splitSeat = new char[seat.length()];

        for(int i = 0; i < numberOfSeat; i++)
            splitSeat[i] = (seat.charAt(i));


        for(int i = 0; i < numberOfSeat; i++) {
            if(splitSeat[i] == 'S') {
                answer++;
            }
            else if(splitSeat[i] == 'L') {
                answer += 0.5;
            }
        }

        answer++;

        if (numberOfSeat < answer)
            System.out.println(numberOfSeat);
        else
            System.out.println((int)answer);

    }
}