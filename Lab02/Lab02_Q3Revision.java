
/*Modify your program such that given input String should have
even length and at least 4 characters. Determine if the String
is a special string by comparing the first, two middle and last
characters. A string is special if one of two middle or last
characters is close to the first, while the other is far.*/

import java.util.Scanner;

public class Lab02_Q3Revision {
    public static void main(String[] args) {
        String input;
        char first;
        String middle;
        char last;
        boolean isSpecial;
        boolean isLowerCase = false;
        char charin;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        // Inputting string and declaring chars
        input = in.nextLine();
        first = input.charAt(0);
        middle = input.substring(input.length() / 2 - 1, input.length() / 2 + 1);
        last = input.charAt(input.length() - 1);
        // Conditions
        for (int a = 0; a < input.length(); a++) {
            charin = input.charAt(a);
            if (Character.isLetter(charin) || Character.isWhitespace(charin)) {
                isLowerCase = true;
            } else {

                isLowerCase = false;

            }
        }
        if (input != input.toLowerCase() || isLowerCase == false) {
            System.out.println("Characters not lowercase letters... ");
            isSpecial = false;
        }

        else {
            if (input.length() < 4 || input.length() % 2 != 0) {
                System.out.println("Lenght of string not sufficient or not even numbered.");

            } else if (isLowerCase == true && (input.length() >= 4 && input.length() % 2 == 0)) {
                System.out.printf("first: %c middle: %s last: %c\n", first, middle, last);

                if ((Math.abs(middle.charAt(0) - first) <= 1 || middle.charAt(1) - first <= 1)
                        && (Math.abs(last - middle.charAt(0)) >= 2 && Math.abs(last - middle.charAt(1)) >= 2)
                        && Math.abs(last - first) >= 2) {
                    isSpecial = true;
                    System.out.println("String is special:" + isSpecial);
                } else if (Math.abs(last - first) <= 1 && (((Math.abs(last - middle.charAt(0)) >= 2)
                        && (Math.abs(last - middle.charAt(1)) >= 2)
                        && ((Math.abs(middle.charAt(0) - first) >= 2) && (Math.abs(middle.charAt(1) - first) >= 2))))) {
                    isSpecial = true;
                    System.out.println("String is special:" + isSpecial);
                }

                else {

                    isSpecial = false;

                    System.out.println("String is special: " + isSpecial);
                }
            }
        }
        in.close();
    }

}
