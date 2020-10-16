import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        int priceNotMore60Number = 10;
        int priceFrontHalf = 10;
        int priceBackHalf = 8;
        int totalIncome;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();

        int totalNumberOfSeats = numberOfRows * numberOfSeats;

        if (totalNumberOfSeats <= 60) {
            System.out.println("Total income:");
            totalIncome = totalNumberOfSeats * priceNotMore60Number;
        } else {
            int frontHalfOfRows = numberOfRows / 2;
            int backHalfOfRows = numberOfRows - frontHalfOfRows;
            totalIncome = frontHalfOfRows * numberOfSeats * priceFrontHalf
                    + backHalfOfRows * numberOfSeats * priceBackHalf;
        }
        System.out.println("$" + totalIncome);
    }
}