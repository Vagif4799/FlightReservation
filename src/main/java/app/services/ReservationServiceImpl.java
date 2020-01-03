package app.services;

import app.dto.ReservationRequest;
import app.entities.Flight;
import app.entities.Passenger;
import app.entities.Reservation;
import app.repos.FlightRepository;
import app.repos.PassengerRepository;
import app.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        // Make Payment, Then the next steps.
        // For now, it is completely for free ;)

        Long flightId = request.getFlightId();
        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        Flight flight = flightOptional.get();

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);

        return savedReservation;
    }

}
