import java.util.Scanner;

public class Lab02_Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a real number: ");
        if (!in.hasNextDouble()) {
            System.out.println("Invalid input - value must be numeric");
        }
        else {
            double inputValue = in.nextDouble();
            if (inputValue > 15) {
                System.out.printf("f(x) = %.2f", Math.sqrt(Math.pow(inputValue, 5) + 1));
            } else if (inputValue <= 15 && inputValue >= 0) {
                System.out.printf("f(x) = %.2f", Math.exp(inputValue) - 15);
            } else {
                System.out.printf("f(x) = %.2f", inputValue / inputValue + 10);
            }
        }
        in.close();
    }
}
