import java.time.LocalDateTime;
import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();  // Capture current time as booking time
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head;
    
    TicketReservationSystem() {
        head = null;
    }

    void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber);

        if (head == null) {
            head = newTicket;
            head.next = head;  // Circular link to itself
        } else {
            Ticket current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newTicket;
            newTicket.next = head;  // Circular link to head
        }
    }

    void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket prev = null;
        
        do {
            if (current.ticketId == ticketId) {
                if (prev == null) {  // Removing the head node
                    if (current.next == head) {  // Only one ticket in the list
                        head = null;
                    } else {
                        Ticket last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = current.next;
                        last.next = head;
                    }
                } else {
                    prev.next = current.next;
                }
                System.out.println("Ticket ID " + ticketId + " has been removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        
        System.out.println("Ticket ID " + ticketId + " not found.");
    }

    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId +
                               ", Customer: " + current.customerName +
                               ", Movie: " + current.movieName +
                               ", Seat: " + current.seatNumber +
                               ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    void searchTicket(String nameOrMovie) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(nameOrMovie) || current.movieName.equalsIgnoreCase(nameOrMovie)) {
                System.out.println("Ticket ID: " + current.ticketId +
                                   ", Customer: " + current.customerName +
                                   ", Movie: " + current.movieName +
                                   ", Seat: " + current.seatNumber +
                                   ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found matching \"" + nameOrMovie + "\".");
        }
    }

    int getTotalTickets() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("Ticket Reservation System:");
            System.out.println("1. Add New Ticket");
            System.out.println("2. Remove Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer Name or Movie Name");
            System.out.println("5. Get Total Number of Booked Tickets");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            if (choice == 1) {
                System.out.print("Enter Ticket ID: ");
                int ticketId = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter Customer Name: ");
                String customerName = scanner.nextLine();
                System.out.print("Enter Movie Name: ");
                String movieName = scanner.nextLine();
                System.out.print("Enter Seat Number: ");
                String seatNumber = scanner.nextLine();
                system.addTicket(ticketId, customerName, movieName, seatNumber);
            } else if (choice == 2) {
                System.out.print("Enter Ticket ID to remove: ");
                int ticketId = scanner.nextInt();
                system.removeTicket(ticketId);
            } else if (choice == 3) {
                system.displayTickets();
            } else if (choice == 4) {
                System.out.print("Enter Customer Name or Movie Name to search: ");
                String searchTerm = scanner.nextLine();
                system.searchTicket(searchTerm);
            } else if (choice == 5) {
                System.out.println("Total Booked Tickets: " + system.getTotalTickets());
            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }
}
