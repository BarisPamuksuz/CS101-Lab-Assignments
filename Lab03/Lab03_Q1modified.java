import java.util.Scanner;
import java.util.Random;
public class Lab03_Q1modified {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rndm = new Random();
        String a1;
        String a2;
        String encoded1 = "willbeinitialized";
        String encoded2 = "";
        String wordToDecode = "";
        String wordToEncode = "willbeinitialized";
        String wordToEncode2 = "willbeinitialized";
        String decoded;
        String decoded2;
        String replaced = "";
        
        int position1 = 0;
        int position2 = 0;
        
        boolean flag1 = false;
        boolean flag2 = false;
        String menu = "1) Encode Message\n2) Decode Message\n3) Encode2 Message\n4) Decode2 Message\n5)Quit\nEnter choice: ";
        int choice = 0;
        System.out.print(menu);
        boolean validinput = in.hasNextInt();
        
        if (validinput){
            choice = in.nextInt();
            
            in.nextLine();
            while ( validinput == true && choice < 5 && choice >= 1){
            
                if (choice == 2 && flag1 == false && validinput == true ){
                    System.out.println("No message to decode...\n");
                    System.out.print(menu);
                    if (!in.hasNextInt()){
                    validinput = false;
                    }
                    else{
                    choice = in.nextInt();
                    in.nextLine();
                    }
                }
                if (choice == 2 && flag1 == true && validinput == true){
                    //decoding algorithm
                    
                    while( position1 < encoded1.length()){
                        if (Character.isLetter(encoded1.charAt(position1)) || Character.isWhitespace(encoded1.charAt(position1))){
                            wordToDecode += encoded1.charAt(position1); 
                        }
                        position1 += 1;
                    }
                    decoded =wordToDecode.substring(wordToDecode.indexOf(" ")+1) + wordToDecode.substring(0,wordToDecode.indexOf(" "));
                    System.out.println("The decoded message is: " + decoded);
                


                    flag1 = false;
                    System.out.print(menu);
                    if (!in.hasNextInt()){
                    validinput = false;
                    }
                    else{
                    choice = in.nextInt();
                    in.nextLine();
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
                        encoded1 = a2 + " " + a1;
                        
                        
                        
                        int control = encoded1.length() - 1;
                        while (control != 0){
                            int seppoint2 = rndm.nextInt(encoded1.length()+1)+0;
                            int digit = rndm.nextInt(10) + 0;
                            encoded1 = encoded1.substring(0, seppoint2) + digit + encoded1.substring(seppoint2);
                            control = control - 1;
                        }
                        System.out.println("Encoded message: " + encoded1 );
                        flag1 = true;
                        System.out.print(menu);
                        if (!in.hasNextInt()){
                        validinput = false;
                        }
                        else{
                        choice = in.nextInt();
                        in.nextLine();
                        }
                    }
                    else{
                        System.out.println("Invalid length word - try again");
                    }
                }
                if ( choice == 4 && flag2 == false && validinput == true){
                    System.out.println("No message to decode...\n");
                    System.out.print(menu);
                    if (!in.hasNextInt()){
                    validinput = false;
                    }
                    else{
                    choice = in.nextInt();
                    in.nextLine();
                    }
                }
                if ( choice == 4 && flag2 == true ){
                    //decoding algo..
                    
                    encoded2 =  encoded2.replace("*","");
                    decoded2 = encoded2.substring(2) +  replaced.charAt(replaced.length() - 1) +  encoded2.substring(0, 2);
                    System.out.println("Decoded message is: "+ decoded2);
                    flag2 = false;
                    System.out.print(menu);
                    if (!in.hasNextInt()){
                    validinput = false;
                    }
                    else{
                    choice = in.nextInt();
                    in.nextLine();
                    }

                }
                while ( choice == 3 ){
                    
                    System.out.print("Enter word to encode: ");
                    encoded2 = "";
                    position2 = 0;
                    wordToEncode2 = in.nextLine();
                    
                    if (wordToEncode2.length() >= 2 ){
                        replaced = wordToEncode2.substring(wordToEncode2.length() - 2) + wordToEncode2.substring(0 , wordToEncode2.length() - 2 );
                        while ( position2 < wordToEncode2.length() - 1){
                            
                            
                            encoded2 += replaced.substring(position2, position2 + 1) + "*";
                            position2++;
                        }
                        if (replaced.indexOf(" ") != -1 ){
                            encoded2 =  encoded2.replace("* *"," ");
                            
                            }
                        System.out.println("Encoded message is: " + encoded2 + replaced.charAt(replaced.length() - 1));
                        flag2 = true;
                        System.out.print(menu);
                        if (!in.hasNextInt()){
                        validinput = false;
                        }
                        else{
                        choice = in.nextInt();
                        in.nextLine();
                        }
                    }
                    
                    else{
                        System.out.println("Invalid length word - try again.");
                    }
                }
        }
        }
        if (choice == 5){
            System.out.println("Thank you, good bye!");
        }
        else {
            System.out.println("Invalid input, please enter choice between 1-3");
        }
    in.close();
    }
}

