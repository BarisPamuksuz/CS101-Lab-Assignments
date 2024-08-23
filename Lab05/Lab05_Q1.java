/** Lab05 question 1
 *  @author Barış Pamuksuz
 *  22202238
 */

import java.util.Scanner;

public class Lab05_Q1 {
    // Number of  multiplacation of digits until reaching a single digit. i.e 89->72->14->4 #3.
    public static int persistence( int num ) {
        int count = 0;
        int b;
        int multi = 1;
        while(num >= 10){
            while(num >= 1){
                b = num % 10;
                multi *= b;
                num /= 10;
            }
            num = multi;
            count++;
            multi = 1;
        }
    return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;
        int answer;
        boolean repeat = true;
        
        while(repeat){
        System.out.print("Enter a positive integer: ");
            if (in.hasNextInt()){
                num = in.nextInt();
                if (num > 0){
                    answer = persistence(num);
                    System.out.printf("multiplicative persistence of %d is %d", num, answer);
                    repeat = false;
                }
                else if( num <= 0 ){
                    
                    in.nextLine();
                    repeat = true;
                }   
            }
            else{
            in.nextLine();
            }
        }
    in.close();
    }
}

