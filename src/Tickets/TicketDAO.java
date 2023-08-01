package Tickets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    private Connection connection;

    public TicketDAO() {
        try {
            // Update the database URL, username, and password accordingly
            String url = "jdbc:mysql://localhost:3306/ticketing";
            String username = "root";
            String password = "navi@123";

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTicket(Ticket ticket) {
        try {
            String query = "INSERT INTO tickets (description, status) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ticket.getDescription());
            preparedStatement.setString(2, ticket.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTicketStatus(int ticketId, String status) {
        try {
            String query = "UPDATE tickets SET status = ? WHERE ticketId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, ticketId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        try {
            String query = "SELECT * FROM tickets";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("ticketId");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                Ticket ticket = new Ticket(id, description, status);
                tickets.add(ticket);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}