import java.util.Scanner;

public class Lab02_Q2 {
    public static void main(String[] args) {

        int smaJars;
        int bigJars;
        int orderSize;

        Scanner in = new Scanner(System.in);
        System.out.print("Input the number of small and large jars available and the order size: ");
        smaJars = in.nextInt();
        bigJars = in.nextInt();
        orderSize = in.nextInt();
        int remainer = orderSize - 5 * bigJars;

        if (orderSize < 5) {
            System.out.println("Order must be larger than 5 litres");
        }
        else {
            if (orderSize / 5 >= bigJars && (orderSize - 5 * bigJars) <= smaJars) {
                System.out.printf("Order of %d litres will contain %d small (1 litre) jars %d big(5 litre) jars",
                        orderSize, remainer, (orderSize - remainer) / 5);
            } else if (orderSize / 5 < bigJars && orderSize % 5 <= smaJars) {
                System.out.printf("Order of %d litres will contain %d small (1 litre) jars %d big(5 litre) jars",
                        orderSize, orderSize % 5, (orderSize - (orderSize % 5)) / 5);
            } else {
                System.out.println("You do not enough jars to complete the order.");
            }

        }
        in.close();
    }
}
