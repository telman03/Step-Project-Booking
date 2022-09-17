package az.company.booking_project.Services;


import az.company.booking_project.DAO.BookingDao;
import az.company.booking_project.entities.*;
import az.company.booking_project.entities.Booking;
import az.company.booking_project.entities.Database;
import az.company.booking_project.entities.Flight;
import az.company.booking_project.entities.Passenger;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class BookingService {
    private BookingDao bookingDao=new BookingDao();
    Database database= new Database();
    Flight flight;

    public boolean makeBooking(int tickets ) {
        return bookingDao.create(bookingDao.makeBooking(tickets));
    }

    public List<Booking> showMyBookings() throws IOException, ClassNotFoundException {
        return bookingDao.getAll();
    }

    public Optional<Booking> findBookingById(int bookingId) {
        return bookingDao.getById(bookingId);
    }

    public void cancelBooking(int cancelID) throws IOException, ClassNotFoundException {
        bookingDao.delete(cancelID);
    }
    public boolean createBooking(int flight_id, List<Passenger> passenger) {
        bookingDao.create(new Booking(flight_id, passenger));
        return database.writeToFileBooking();
    }
}
