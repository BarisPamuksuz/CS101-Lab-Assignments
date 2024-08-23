import java.util.Scanner;

public class Lab02_Q3 {
    public static void main(String[] args) {
        String input;
        char first;
        char middle;
        char last;
        boolean isSpecial;
        boolean isLowerCase = true;
        char charin;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        
        input = in.nextLine();
        first = input.charAt(0);
        middle = input.charAt(Math.round((input.length() - 1) / 2));
        last = input.charAt(input.length() - 1);
        // Conditions
        for (int a = 0; a < input.length(); a++) {
            charin = input.charAt(a);
            if (!Character.isLowerCase(charin) && !Character.isWhitespace(charin)) {
                isLowerCase = false;
            }
        }
        if (input != input.toLowerCase() || isLowerCase == false) {
            System.out.println("Characters not lowercase letters... ");
        }

        if (input.length() < 3) {
            System.out.println("Length of string not sufficient");
        }

        else {
            if (isLowerCase == true && input.length() >= 3) {

                if (Math.abs(middle - first) <= 1 && (Math.abs(last - middle) >= 2 && Math.abs(last - first) >= 2)) {
                    isSpecial = true;
                    System.out.printf("first: %c middle: %c last: %c\n", first, middle, last);
                } else if (Math.abs(last - first) <= 1
                        && (Math.abs(last - middle) >= 2 && Math.abs(middle - first) >= 2)) {
                    System.out.printf("first: %c middle: %c last: %c\n", first, middle, last);
                    isSpecial = true;
                } else {
                    System.out.printf("first: %c middle: %c last: %c\n", first, middle, last);
                    isSpecial = false;
                }
                System.out.println("String is special:" + isSpecial);
            }
            in.close();
        }
    }
}
