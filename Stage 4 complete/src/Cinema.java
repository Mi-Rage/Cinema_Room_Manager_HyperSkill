import java.util.Scanner;

public class Cinema {

    private static char[][] cinemaHall;
    private static final int priceNotMore60Number = 10;
    private static final int priceFrontHalf = 10;
    private static final int priceBackHalf = 8;

    private static final char SEAT = 'S';
    private static final char BUSY = 'B';

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        createCinemaHall();
        int command;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    printCinemaHall(cinemaHall);
                    break;
                case 2:
                    takeTicket(cinemaHall);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Error! Wrong command!");
            }
        } while (command != 0);
    }

    public static void createCinemaHall() {
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();

        if (numberOfRows <= 9 && numberOfSeats <= 9) {
            cinemaHall = new char[numberOfRows][numberOfSeats];
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfSeats; j++) {
                    cinemaHall[i][j] = SEAT;
                }
            }
        } else {
            System.out.println("Error! Some number greater than 9!");
            System.exit(-1);
        }
    }

    public static void printCinemaHall(char[][] cinemaHall) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinemaHall[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < cinemaHall.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinemaHall[0].length; j++) {
                System.out.print(" " + cinemaHall[i][j]);
            }
            System.out.println();
        }
    }

    public static void takeTicket(char[][] cinemaHall) {
        int totalNumberOfSeats = cinemaHall.length * cinemaHall[0].length;

        System.out.println("Enter a row number:");
        int seatRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        int priceTicket;

        if (totalNumberOfSeats <= 60) {
            priceTicket = priceNotMore60Number;
        } else {
            int frontHalfOfRows = cinemaHall.length / 2;
            if (seatRow <= frontHalfOfRows) {
                priceTicket = priceFrontHalf;
            } else {
                priceTicket = priceBackHalf;
            }
        }

        System.out.println("Ticket price: $" + priceTicket);
        cinemaHall[seatRow - 1][seatNumber - 1] = BUSY;
    }
}