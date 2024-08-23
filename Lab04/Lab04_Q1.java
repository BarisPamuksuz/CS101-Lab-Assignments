/** Lab04 Question 1 
 * @author Barış Pamuksuz
 * 
 * 
 */
import java.util.Scanner;

public class Lab04_Q1{
    public static void main(String[] args) {
        int min;
        int max;
        int a = 1;
        int d = 365;
        
        double repeatedTerm;
        double change;
        double probability;
        Scanner in = new Scanner( System.in );
        do{
            System.out.print("Enter the minimum and maximum number of people: ");
            min = in.nextInt();
            max = in.nextInt();
            
            if ( min >= max){
                System.out.println("Invalid input - minimum must be less than maximum...");
            }
        } while(min >= max);
        System.out.printf("%-16s%16s\n","NUMBER OF PEOPLE","PROBABILITY");
        for (; min <= max; min++){
            repeatedTerm = (((d - ((double)min - 1)) / d));
            for ( a = 2; a <= min; a++){
                change = (((d - ((double)min - a)) / d));
                repeatedTerm *= change ;
            }
        probability = (1 - repeatedTerm);
        System.out.printf("%-16d%10.3f\n",min,probability);
        }
    }
}