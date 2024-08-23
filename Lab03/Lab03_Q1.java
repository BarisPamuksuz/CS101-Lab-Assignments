import java.util.Scanner;
import java.util.Random;
public class Lab03_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rndm = new Random();
        String a1;
        String a2;
        String totalWord = "willbeinitialized";
        String wordToDecode = "";
        String decoded;
        int position;
        boolean flag = false;
        String wordToEncode = "willbeinitialized";
        String menu = "1) Encode Message\n2) Decode Message\n3) Quit\nEnter choice: ";
        int choice = 0;
        System.out.print(menu);
        boolean validinput = in.hasNextInt();
        
        if (validinput){
            choice = in.nextInt();
            while ( validinput == true && choice < 3 && choice >= 1){
            
                if (choice == 2 && flag == false & validinput){
                    System.out.println("No message to decode...\n");
                    System.out.print(menu);
                    if (!in.hasNextInt()){
                    validinput = false;
                    }
                    else{
                    choice = in.nextInt();
                    }
                }
                if (choice == 2 && flag == true & validinput){
                    //decoding algorithm
                    position = 0;
                    while( position < totalWord.length()){
                        if (Character.isLetter(totalWord.charAt(position)) || Character.isWhitespace(totalWord.charAt(position))){
                            wordToDecode += totalWord.charAt(position); 
                        }
                        position += 1;
                    }
                    decoded =wordToDecode.substring(wordToDecode.indexOf(" ")+1) + wordToDecode.substring(0,wordToDecode.indexOf(" "));
                    System.out.println("The decoded message is: " + decoded);
                
                    flag = false;
                    System.out.print(menu);
                    if (!in.hasNextInt()){
                    validinput = false;
                    }
                    else{
                    choice = in.nextInt();
                    }
                }
                while (choice == 1 && validinput == true){
                    System.out.print("Enter word to encode: ");
                    wordToEncode = in.next();
                    if (wordToEncode.length() >= 2 & validinput){
                        // encoding algorithm...
                        
                        int seppoint = rndm.nextInt(wordToEncode.length()-1) + 1;
                        a1 = wordToEncode.substring(0, seppoint);
                        a2 =wordToEncode.substring(a1.length());
                        totalWord = a2 + " " + a1;
                        
                        int control = totalWord.length() - 1;
                        while (control != 0){
                            int seppoint2 = rndm.nextInt(totalWord.length()+1)+0;
                            int digit = rndm.nextInt(10) + 0;
                            totalWord = totalWord.substring(0, seppoint2) + digit + totalWord.substring(seppoint2);
                            control = control - 1;
                        }
                        System.out.println("Encoded message: " + totalWord );
                        flag = true;
                        System.out.print(menu);
                        if (!in.hasNextInt()){
                        validinput = false;
                        }
                        else{
                        choice = in.nextInt();
                        }
                    }
                    else{
                        System.out.println("Invalid length word - try again");
                    }
                }
        }
        }
        if (choice == 3){
            System.out.println("Thank you, good bye!");
        }
        else {
            System.out.println("Invalid input, please enter choice between 1-3");
        }
    in.close();
    }
}
