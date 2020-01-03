package app.controllers;

import app.entities.Flight;
import app.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        Flight flight = flightOptional.get();
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }

}
