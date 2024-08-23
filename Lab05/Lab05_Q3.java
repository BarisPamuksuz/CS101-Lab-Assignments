import java.util.Scanner;

public class Lab05_Q3 {

    public static void convertWord(String word) {

        String newWord;
        int count;
        newWord = "";
        if (!word.equalsIgnoreCase("exit")) {
            for (int i = 0; i < word.length(); i++) {
                if (!Character.isLetter(word.charAt(i))) {
                    newWord += '*';
                } else {
                    count = 1;
                    count = countLetter(word, i);
                    if (count != 1) {
                        newWord += ")";
                    } else {
                        newWord += "(";
                    }
                }
            }
        }
        // word = newWord;
        System.out.printf("Original word: %s\tConverted word: %s%n", word, newWord);
        System.out.println();
    }

    public static void displayChart(String chartData) {
        final String LABEL = "review";
        int maxDigit;
        int pos;
        pos = -1;
        do {
            pos++;
        } while (pos < chartData.length() && Character.isDigit(chartData.charAt(pos)));

        if (pos != chartData.length()) {
            System.out.println("Invalid chart data!");
        } else {
            // display chart headings
            for (int i = 1; i <= chartData.length(); i++) {
                System.out.printf("%10s", LABEL + " " + i);
            }
            System.out.println();

            maxDigit = -1;

            int NumericChartdata = Integer.parseInt(chartData);
            maxDigit = findMax(NumericChartdata);

            for (int line = maxDigit; line > 0; line--) {

                for (int ch = 0; ch < chartData.length(); ch++) {

                    int current = Character.getNumericValue(chartData.charAt(ch));
                    if (current >= line) {

                        System.out.printf("%10s", "***");
                    } else {

                        System.out.printf("%10s", "");
                    }
                }

                System.out.println();
            }

        }
        System.out.println();
    }

    public static double sameBirthday(int groupsize) {

        int a = 1;
        int d = 365;

        double repeatedTerm;
        double change;
        double probability;

        repeatedTerm = (((d - ((double) groupsize - 1)) / d));
        for (a = 2; a <= groupsize; a++) {
            change = (((d - ((double) groupsize - a)) / d));
            repeatedTerm *= change;
        }
        probability = (1 - repeatedTerm);
        System.out.printf("The probablity of two people in a group of %d having the same birthday is %.2f\n\n",
                groupsize, probability);

        return probability;
    }

    public static int getChoice() {
        Scanner a = new Scanner(System.in);
        int input;

        input = a.nextInt();
        return input;
    }

    public static void displayMenu() {
        System.out
                .print("1- Find Probability of Same Birthday\n2- Draw chart\n3- Convert Word\n4- QUIT\nEnter choice: ");
    }

    public static boolean isValidNumeric(String chartData) {

        for (int i = 0; i <= chartData.length() - 1; i++) {
            if (!Character.isDigit(chartData.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int findMax(int NumericChartdata) {
        String chartData = String.valueOf(NumericChartdata);
        int maxDigit = -1;

        for (int i = 0; i < chartData.length(); i++) {
            int current = Character.getNumericValue(chartData.charAt(i));
            if (current > maxDigit) {
                maxDigit = current;
            }

        }
        return maxDigit;
    }

    public static int countLetter(String word, int i) {
        int count = 1;
        for (int j = 0; j < word.length(); j++) {
            if (i != j && Character.toUpperCase(word.charAt(i)) == Character.toUpperCase(word.charAt(j))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        displayMenu();
        int choice = getChoice();
        while (choice != 4) {
            if (choice == 1) {
                System.out.print("Enter group size: ");
                int groupSize = in.nextInt();
                sameBirthday(groupSize);
                displayMenu();
                choice = getChoice();
            } else if (choice == 2) {
                System.out.print("Enter chart data: ");
                String chartData = in.next();
                displayChart(chartData);
                displayMenu();
                choice = getChoice();
            } else if (choice == 3) {
                System.out.print("Enter word to convert: ");
                String word = in.next();
                convertWord(word);
                displayMenu();
                choice = getChoice();
            } else {
                System.out.println("Invalid choice, enter again.\n");
                displayMenu();
                choice = getChoice();
            }

        }
        if (choice == 4) {
            System.out.println("GOODBYE!");
        }

        in.close();
    }
}
