package Tickets;
import java.util.Scanner;

public class ITSupportTicketApp {
    public static void main(String[] args) {
        TicketManager ticketManager = new TicketManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Raise a ticket");
            System.out.println("2. Resolve a ticket");
            System.out.println("3. View all tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character from the buffer

            switch (choice) {
                case 1:
                    ticketManager.raiseTicket(scanner);
                    break;

                case 2:
                    ticketManager.resolveTicket(scanner);
                    break;

                case 3:
                    ticketManager.viewAllTickets();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    ticketManager.closeTicketDAO();
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
