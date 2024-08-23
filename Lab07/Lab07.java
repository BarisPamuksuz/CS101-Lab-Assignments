
/**
 * @author Barış Pamuksuz 22202238
 * CS101 Lab07 Party Planner
 */

import java.util.Scanner;

import java.util.Arrays;

public class Lab07 {
    private static String[] friendsNames = { "Ela", "Eren", "Alona", "Jen", "Mark", "Mel", "Ender" };
    private static Integer[] ArrivalsList = { 9, 5, 8, 7, 9, 7, 8 };
    private static Integer[] DeparturesList = { 12, 7, 11, 12, 10, 9, 10 };

    public static Integer[] friendsAttending(int arrival, int departure) {
        int u = 0;
        int count = 0;
        int max = count;
        int bestTime = arrival;

        Integer[] attendanceList = new Integer[departure - arrival];
        int i = arrival;
        while (i < departure) {
            for (int m = 0; m < ArrivalsList.length; m++) {
                if (i >= ArrivalsList[m] && i < DeparturesList[m]) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                bestTime = i;
            }
            attendanceList[u] = count;
            System.out.printf("At %dpm, %d friends will be at the party\n", i, count);
            count = 0;
            u++;
            i++;
        }
        System.out.println("Best time to attend is " + bestTime);

        return attendanceList;
    }

    public static int maxFinder(int arrival, int departure) {

        int count = 0;
        int max = count;

        int i = arrival;
        while (i < departure) {
            for (int m = 0; m < ArrivalsList.length; m++) {
                if (i >= ArrivalsList[m] && i < DeparturesList[m]) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
            }
            count = 0;
            i++;
        }
        return max;
    }

    public static int bestTimeFinder(int arrival, int departure) {

        int count = 0;
        int max = count;
        int bestTime = -1;
        int i = arrival;
        while (i < departure) {
            for (int m = 0; m < ArrivalsList.length; m++) {
                if (i >= ArrivalsList[m] && i < DeparturesList[m]) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                bestTime = i;
            }

            count = 0;
            i++;
        }

        return bestTime;
    }

    public static int bestTimeToAttend(String nameToAvoid, int arrival, int departure) {
        boolean flag = true;
        int i = 0;
        int bestTime = -1;
        while (flag && i < friendsNames.length) {

            if (friendsNames[i].equals(nameToAvoid)) {
                flag = false;
            } else {
                i++;
            }
        }
        if (arrival == ArrivalsList[i] && departure == DeparturesList[i]) {
            return -1;
        } else if (arrival == ArrivalsList[i] && departure > DeparturesList[i]) {
            bestTime = bestTimeFinder(DeparturesList[i], departure);
            System.out.printf("Best time to attend to avoid %s and to see the most friends is %d\n", nameToAvoid,
                    bestTime);

        } else if (arrival < ArrivalsList[i] && departure == DeparturesList[i]) {
            bestTime = bestTimeFinder(arrival, ArrivalsList[i]);
            System.out.printf("Best time to attend to avoid %s and to see the most friends is %d\n", nameToAvoid,
                    bestTime);

        } else if (arrival < ArrivalsList[i] && departure > DeparturesList[i]) {
            int max1 = maxFinder(arrival, ArrivalsList[i]);
            int max2 = maxFinder(DeparturesList[i], departure);
            if (max1 >= max2) {
                bestTime = bestTimeFinder(arrival, ArrivalsList[i]);
            } else {
                bestTime = bestTimeFinder(DeparturesList[i], departure);
            }
            System.out.printf("Best time to attend to avoid %s and to see the most friends is %d\n", nameToAvoid,
                    bestTime);
        } else{
            System.out.println("No escape from him/her.");
        }

        return bestTime;
    }

    public static void main(String[] args) {

        int arrival;
        int departure;
        int arrival1;
        int departure1;
        String nameToAvoid;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter time interval you are available:");
        arrival = in.nextInt();
        departure = in.nextInt();
        in.nextLine();

        friendsAttending(arrival, departure);

        System.out.print("Enter friend you wish to avoid: ");
        nameToAvoid = in.nextLine();
        System.out.print("Enter time interval you are available:");
        arrival1 = in.nextInt();
        departure1 = in.nextInt();
        in.nextLine();

        bestTimeToAttend(nameToAvoid, arrival1, departure1);

        in.close();

    }

}
