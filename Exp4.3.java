class TicketBookingSystem {
    private boolean[] seats;

    public TicketBookingSystem(int totalSeats) {
        seats = new boolean[totalSeats];
    }

    public synchronized void bookSeat(String name, int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println(name + ": Invalid seat number!");
            return;
        }
        
        seatNumber--;
        
        if (seats[seatNumber]) {
            System.out.println(name + ": Seat " + (seatNumber + 1) + " is already booked!");
        } else {
            seats[seatNumber] = true;
            System.out.println(name + " booked seat " + (seatNumber + 1));
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private String name;
    private int seatNumber;

    public BookingThread(TicketBookingSystem system, String name, int seatNumber) {
        this.system = system;
        this.name = name;
        this.seatNumber = seatNumber;
    }

    public void run() {
        system.bookSeat(name, seatNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(5);
        
        BookingThread thread1 = new BookingThread(system, "Anish (VIP)", 1);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        
        BookingThread thread2 = new BookingThread(system, "Bobby (Regular)", 2);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread2.start();
        
        BookingThread thread3 = new BookingThread(system, "Charlie (VIP)", 3);
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread3.start();
        
        BookingThread thread4 = new BookingThread(system, "Bobby (Regular)", 4);
        thread4.setPriority(Thread.MIN_PRIORITY);
        thread4.start();
        
        BookingThread thread5 = new BookingThread(system, "Anish (VIP)", 4);
        thread5.setPriority(Thread.MAX_PRIORITY);
        thread5.start();
        
        BookingThread thread6 = new BookingThread(system, "Bobby (Regular)", 1);
        thread6.setPriority(Thread.MIN_PRIORITY);
        thread6.start();
        
        BookingThread thread7 = new BookingThread(system, "New User (Regular)", 3);
        thread7.setPriority(Thread.NORM_PRIORITY);
        thread7.start();
        
        BookingThread thread8 = new BookingThread(system, "User (Invalid)", 0);
        thread8.setPriority(Thread.NORM_PRIORITY);
        thread8.start();
        
        BookingThread thread9 = new BookingThread(system, "User (Invalid)", 6);
        thread9.setPriority(Thread.NORM_PRIORITY);
        thread9.start();
    }
}


//output

Output:

Anish (VIP) booked seat 1
User (Invalid): Invalid seat number!
User (Invalid): Invalid seat number!
New User (Regular) booked seat 3
Bobby (Regular): Seat 1 is already booked!
Anish (VIP) booked seat 4
Bobby (Regular): Seat 4 is already booked!
Charlie (VIP): Seat 3 is already booked!
Bobby (Regular) booked seat 2
