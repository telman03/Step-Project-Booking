package az.company.booking_project.DAO;


import az.company.booking_project.entities.Booking;
import az.company.booking_project.entities.Database;
import az.company.booking_project.entities.Passenger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookingDao implements Dao<Booking> {

    private Database database = new Database();
    private Booking booking;

    @Override
    public List<Booking> getAll() {
        return database.getAllBookings();
    }

    @Override
    public Optional<Booking> get(Booking booking) {
        return Optional.empty();
    }

    @Override
    public Optional<Booking> getById(int id) {
        return database.getBookingList()
                .stream()
                .filter(booking -> booking.getId() == id)
                .findFirst();
    }

    @Override
    public boolean create(Booking booking) {
        database.getBookingList().add(booking);
        return database.writeToFileBooking();
    }

    @Override
    public boolean delete(int id) throws IOException, ClassNotFoundException {
        List<Booking> collect = database.getAllBookings()
                .stream()
                .filter(booking -> booking.getId() == id)
                .collect(Collectors.toList());
        database.getBookingList().removeAll(collect);
        return database.writeToFileBooking();

    }


    public Booking makeBooking(int tickets) {
        List<Passenger> passengers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter flight ID:");
        int id = scanner.nextInt();
        for (int i = 1; i <=tickets; i++) {
            System.out.println("Enter Passenger's Name:");
            String name = scanner.next();
            System.out.println("Enter Passenger's Surname:");
            String surname = scanner.next();

            passengers.add(new Passenger(name, surname));
        }
        return new Booking(id, passengers);
    }
}
