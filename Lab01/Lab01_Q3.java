
/**
 * @author Barış Pamuksuz 22202238
 * CS101 Intro 
 */

import java.util.Scanner;

public class Lab01_Q3 {
    public static void main(String[] args) {
        double deficitForKilo = 7700;
        double toMaintainKilo = 2000;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter kilograms to lose: ");
        int n1 = in.nextInt();
        System.out.printf("Enter days to lose %d kilograms: ", n1);
        int n2 = in.nextInt();
        double dailyDeficit = deficitForKilo * n1 / n2;
        System.out.printf("To lose %d kilograms in %d days you will need a daily deficit of %.2f calories\n", n1, n2,
                dailyDeficit);
        double recommendedCal = toMaintainKilo - dailyDeficit;
        if (recommendedCal < 0)
            System.out.println("Timeline to lose that much weight is too short and might be unhealthy:(");
        System.out.printf("RECOMMENDED DAILY CALORIES TO LOSE %d KILOS IN %d DAYS: %.2f\n", n1, n2, recommendedCal);
        System.out.print("Enter desired percentage of Carbonhydrates: ");
        int desired = in.nextInt();
        String s1 = "CARBONHYDRATE";
        String s2 = "FAT";
        String s3 = "PROTEIN";
        String s4 = "MACRO";
        String s5 = "DESIRED PERCENT";
        String s6 = "CALORIES PER GRAM";
        String s7 = "DESIRED CALORIES";
        String s8 = "GRAMS";
        int percentFat = (100 - desired) * 3 / 5;
        int percentProtein = (100 - desired) * 2 / 5;
        System.out.printf("%s   \t %s  \t %s    \t  %s  \t  %s\n", s4, s5, s6, s7, s8);
        System.out.printf("%s   \t %7d   \t %17.2f  \t  %16.1f\t  %.1f\n", s1, desired, recommendedCal / 201.9,
                recommendedCal * desired / 100, 201.9);
        System.out.printf("%s   \t %23d  \t %17.2f  \t  %16.1f\t  %.1f\n", s2, percentFat, recommendedCal / 53.8,
                recommendedCal * percentFat / 100, 53.8);
        System.out.printf("%s   \t %15d  \t %17.2f  \t  %16.1f \t  %.1f\n", s3, percentProtein, recommendedCal / 80.8,
                recommendedCal * percentProtein / 100, 80.8);
        in.close();

    }

}
