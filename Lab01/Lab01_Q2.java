
/**
 * @author Barış Pamuksuz 22202238
 * CS101 Intro 
 */

import java.util.Scanner;

public class Lab01_Q2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter time and date: ");
    in.useDelimiter("[\\s,-/:]");

    String hour = in.next();
    String minute = in.next();
    String dayName = in.next();
    String monthName = in.next();
    String dayDate = in.next();
    String year = in.next();
    System.out.printf("%s minutes past %s on %s(year) %s(month) %s %s(day) ", minute, hour, dayDate, monthName, year,
        dayName);
    in.close();
  }
}
