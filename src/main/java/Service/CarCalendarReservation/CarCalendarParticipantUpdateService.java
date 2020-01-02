package Service.CarCalendarReservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.CarCalendarReservation.CarCalendarReservationRepository;

@Service
public class CarCalendarParticipantUpdateService {
	
	@Autowired
	CarCalendarReservationRepository carCalendarReservationRepository;

	public void carParticipantUpdate(Integer calendarNumber) {
		
	}

}
