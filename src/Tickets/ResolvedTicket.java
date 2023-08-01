package Tickets;
public class ResolvedTicket extends Ticket {
    private String resolution;

    public ResolvedTicket(int ticketId, String description, String resolution) {
        super(ticketId, description, "Resolved");
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return super.toString() + "\nResolution: " + resolution;
    }
}