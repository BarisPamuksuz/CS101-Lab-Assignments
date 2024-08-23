
/**
 * @author Barış Pamuksuz 22202238
 * CS101 Intro 
 */

import java.util.Scanner;

public class Lab01_Q1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter x = ");
        double x = in.nextDouble();
        double y = x + 3 / Math.abs(x) + 9 / Math.pow(x, 2);
        System.out.printf("y = %d\n", Math.round(y));

        System.out.printf("%.2f is between %.0f and %.0f", y, Math.floor(y), Math.ceil(y));

        in.close();
    }
}
