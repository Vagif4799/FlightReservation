package app.services;

import app.dto.ReservationRequest;
import app.entities.Reservation;

public interface ReservationService {

     Reservation bookFlight(ReservationRequest request);

}
