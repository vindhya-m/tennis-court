package com.tenniscourts.guests.manager;

import java.util.List;

import com.tenniscourts.guests.Guest;
import com.tenniscourts.guests.model.ServiceResponse;

public interface GuestManager {

	List<Guest> getGuests();

	ServiceResponse addGuest(Guest guest);

	Guest getGuest(Long id);

	Guest getGuest(String Name);

	ServiceResponse updateGuest(Guest guest);

	ServiceResponse deleteGuest(Long id);

}
