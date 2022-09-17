package az.company.booking_project.Controller;


import az.company.booking_project.Services.FlightService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FlightController {

    private FlightService flightService = new FlightService();
    Scanner scanner = new Scanner(System.in);

    public void getAll() throws IOException, ClassNotFoundException {
        flightService.getAll().forEach(System.out::println);
    }

    public void getById(int id) throws IOException, ClassNotFoundException {
        try {
            System.out.println(flightService.getById(id));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void GettAllFlights() throws IOException, ClassNotFoundException {
        System.out.println("<<All possible flights>>");
        getAll();
    }
public void GetFlightsById() throws IOException, ClassNotFoundException {
        try {
            System.out.print("Please enter ID of flight: ");
            int id = scanner.nextInt();
            getById(id);
        }
        catch (InputMismatchException ex){
            System.out.println("enter valid data");
        }
}
}
