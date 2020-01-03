package app.services;

import app.dto.ReservationRequest;
import app.entities.Reservation;
import org.springframework.stereotype.Service;


public interface ReservationService {

     Reservation bookFlight(ReservationRequest request);

}
