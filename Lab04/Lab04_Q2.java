/** Lab04 Question 2 
 * @author Barış Pamuksuz
 * 
 * 
 */
import java.util.Scanner;
public class Lab04_Q2 {
    public static void main(String[] args) {
        boolean valid = true;
        String chartData;
        double averageReview;
        String stars = "       ***";
        String space = "          ";
        int b = 9;
        double total = 0;
        Scanner in = new Scanner( System.in );
        System.out.print("Enter chart data: ");
        chartData = in.next();
        for ( int i = 0; i <= chartData.length()-1; i++){
            if (!Character.isDigit(chartData.charAt(i))){
                valid = false;
                
            }
            
        }
        if (valid == true){
            int number = Integer.parseInt(chartData);
            for(int a = 1; a <= chartData.length(); a++){
                System.out.printf("  review %d", a);
            }
            System.out.print("\n");
            do{
                for (int c = 0; c < chartData.length(); c++){
                    if( Integer.parseInt(chartData.substring(c,c+1)) >= b){
                        System.out.print(stars);
                    }
                    else if (Integer.parseInt(chartData.substring(c,c+1)) < b){
                        System.out.print(space);
                    }
                }
                System.out.print("\n");
                b--;
            }while(b > 0);
            int count = chartData.length();
            while( count != 0){
                total += number % 10;
                number /= 10;
                count--;
            }
            averageReview = total / chartData.length();
            System.out.println(" Average review: " + averageReview);
        }
        else{
            System.out.println("Invalid chart data! Please enter ONLY DIGITS!");
        }
    in.close();
    }
}
