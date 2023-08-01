package Tickets;
import java.util.List;
import java.util.Scanner;

public class TicketManager {
    private TicketDAO ticketDAO;

    public TicketManager() {
        ticketDAO = new TicketDAO();
    }

    public void raiseTicket(Scanner scanner) {
        System.out.print("Enter ticket description: ");
        String description = scanner.nextLine();
        Ticket newTicket = new Ticket(0, description, "Open");
        ticketDAO.insertTicket(newTicket);
        System.out.println("Ticket raised successfully!");
    }

    public void resolveTicket(Scanner scanner) {
        System.out.print("Enter ticket ID to resolve: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character from the buffer

        List<Ticket> allTickets = ticketDAO.getAllTickets();
        boolean ticketExists = false;
        for (Ticket ticket : allTickets) {
            if (ticket.getId() == ticketId) {
                ticketExists = true;
                if (ticket.getStatus().equals("Resolved")) {
                    System.out.println("Ticket is already resolved.");
                } else {
                    System.out.print("Enter resolution details: ");
                    String resolution = scanner.nextLine();
                    ticketDAO.updateTicketStatus(ticketId, "Resolved");
                    System.out.println("Ticket resolved successfully!");
                }
                break;
            }
        }

        if (!ticketExists) {
            System.out.println("Ticket not found with ID: " + ticketId);
        }
    }

    public void viewAllTickets() {
        List<Ticket> allTickets = ticketDAO.getAllTickets();
        for (Ticket ticket : allTickets) {
            System.out.println(ticket);
            System.out.println("-------------------------");
        }
    }

    public void closeTicketDAO() {
        ticketDAO.closeConnection();
    }
}