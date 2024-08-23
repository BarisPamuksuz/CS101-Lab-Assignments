/** Lab04 Question 3 
 * @author Barış Pamuksuz
 * 
 * 
 */import java.util.Scanner;

public class Lab04_Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        String toConvert;
        String converted;
        System.out.print("Enter word to convert: ");
        toConvert = in.next();
        converted = toConvert;
        while (!toConvert.equalsIgnoreCase("exit")){
            
            
            for( int c = 0; c <= converted.length() - 1; c++){
                if( !Character.isLetter(toConvert.charAt(c))){
                    converted = converted.replace(toConvert.charAt(c), '*');
                } 
            }
            
            for( int i = 0; i <= toConvert.length() - 2; i++ ){
                for( int a = 1; a <= toConvert.length() - 1; a++){
                    if((toConvert.charAt(i) == toConvert.charAt(a)) && (a > i) && Character.isLetter(toConvert.charAt(i))){
                        converted = converted.replace(toConvert.charAt(i), ')');
                    }  
                }
            }
            
            for ( int b = 0; b <= converted.length() -1; b++){
                if (Character.isLetter(converted.charAt(b))){
                    converted = converted.replace(converted.charAt(b), '(');
                }
                
            }
            
            System.out.println("Original word: "+ toConvert +"  Converted word: " + converted); 
            System.out.print("Enter word to convert: ");
            toConvert = in.next();
            converted = toConvert;
        }
    in.close();    
    }
}
