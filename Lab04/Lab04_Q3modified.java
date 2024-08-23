/** Lab04 Question 3modified 
 * @author Barış Pamuksuz
 * 
 * 
 */
import java.util.Scanner;

public class Lab04_Q3modified{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String toConvert;
        String converted = "";
        char specialLetter;
        char currentCh;
        int x;
        System.out.print("Enter word to convert: ");
        toConvert = in.next();
        specialLetter = toConvert.charAt(0);
        
        if (toConvert.equals(toConvert.toLowerCase())){
            if (toConvert.length() % 2 == 1){
            specialLetter = toConvert.charAt(toConvert.length()/2);
            
            }
            toConvert = toConvert.replace((specialLetter), '(');
            x = specialLetter - 'a';
            
           
            for(int i = 0; i < toConvert.length(); i++){
                currentCh = toConvert.charAt(i);
                
                
                    if(toConvert.charAt(i) + x <= 122  && !(toConvert.charAt(i) == '(')){
                        converted += (char)(currentCh + x);
                    }
                    else if(toConvert.charAt(i) == '('){
                        converted += currentCh;
                    }
                    else if(toConvert.charAt(i) + x > 122){
                        converted +=(char)(currentCh + x - 26);
                        
                    }
                
            }
            
            System.out.println("Length: " + toConvert.length());
            System.out.println("Special letter: " + specialLetter);
            System.out.println("Converted word: " + converted );
        }
        else{
            System.out.println("Invalid input! Only enter lowercase letters.");
        }   


    in.close();
    }
}
