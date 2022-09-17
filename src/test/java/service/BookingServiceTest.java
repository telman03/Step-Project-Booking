package service;

import az.company.booking_project.Services.BookingService;
import az.company.booking_project.entities.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest extends BookingService {
public static int count=0;

    @Test
    void createBooking() {
        Flight flight2= new Flight(
                ++count,
                Airline.LUFTHANSA,
                Airline.AIR_FRANCE.getCode()+112,
                DepartureCity.getRandomCity(),
                ArrivalCity.AMSTERDAM,
                45,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(4)
        );
        Passenger passenger2 = new Passenger("Telman","Gadimov");
        Passenger passenger3 = new Passenger("Elshan","Gadimov");
        List<Passenger> passengers1= new ArrayList<>();
        passengers1.add(passenger2);
        passengers1.add(passenger3);

assertTrue(createBooking(count,passengers1));
    }
}