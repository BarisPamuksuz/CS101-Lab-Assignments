/** Lab05 question 2
 *  @author Barış Pamuksuz
 *  22202238
 */

import java.util.Scanner;

 public class Lab05_Q2 {
    public static final String KEY = "a@bpdqi!l1mwnuo0s5t+z2A4B8E3G6WM";
    
    
    public static int countNum(String input){
        int count = 0;
        for (int i = 0; i < input.length(); i++){
            if (Character.isDigit(input.charAt(i))){
                count++;
            }
        }
        return count;
    }
    public static char convertChar( char ch1){
        char convertedChar = KEY.charAt(KEY.indexOf(ch1) + 1);
        return convertedChar;
    }
    
    public static String convertText( String input ){
        String convertedText = "";
        boolean isConverted;
            for (int a = 0; a < input.length(); a++){
                char ch2 = input.charAt(a);
                isConverted = false;
                for( int i = 0; i <= 15; i++){
                    if ( KEY.charAt(2 * i) == ch2){
                    convertChar(ch2);
                    convertedText += convertChar(ch2);
                    isConverted = true;
                    }
                }
                if(isConverted == false){
                convertedText += ch2;
                }
            }
        return convertedText;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        System.out.print("Enter a phrase for conversion: ");
        input = in.nextLine();
        if(input.equals("")){
            System.out.println("No phrase entered.");
        }
        else{
            System.out.printf("Text you entered: '%s'\n", input);
            System.out.printf("After conversion: '%s'\n",convertText(input));
            System.out.printf("%d number/s in input\n", countNum(input));
            if(convertText(input).equals(input)){
                System.out.println("No conversion happened.");
            }
        }
    in.close();
    }    
}
