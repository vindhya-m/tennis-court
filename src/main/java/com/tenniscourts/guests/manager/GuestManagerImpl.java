package com.tenniscourts.guests.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenniscourts.guests.Guest;
import com.tenniscourts.guests.exception.GuestNotFoundException;
import com.tenniscourts.guests.model.ServiceResponse;
import com.tenniscourts.guests.repository.GuestRepository;

@Service("guestManager")
public  class GuestManagerImpl implements GuestManager {


	@Autowired
	GuestRepository guestRepository;

	@Override
	public List<Guest> getGuests() {
		List<Guest> guests = guestRepository.findAll();

		if (null == guests || guests.isEmpty())
			throw new GuestNotFoundException("No guests found!");

		return guests;
	}

	@Override
	public ServiceResponse addGuest(Guest guest) {
		guestRepository.save(guest);
		return new ServiceResponse("Successful", "Guest added successfully");
	}

	@Override
	public Guest getGuest(Long id) {
		Guest guest = guestRepository.findByGuestid(id);
		if (guest == null)
			throw new GuestNotFoundException("Invalid guest id!");

		return guest;
	}

	@Override
	public Guest getGuest(String name) {
		Guest guest = guestRepository.findByName(name);
		if (guest == null)
			throw new GuestNotFoundException("Invalid guest name!");

		return guest;
	}

	@Override
	public ServiceResponse updateGuest(Guest guest) {
		guestRepository.save(guest);
		return new ServiceResponse("Successful", "Guest updated successfully");
	}

	@Override
	public ServiceResponse deleteGuest(Long id) {
		Guest guest = guestRepository.findByGuestid(id);
		if (guest != null)
			guestRepository.delete(guest);
		else
			throw new GuestNotFoundException("Invalid guest id!");
		return new ServiceResponse("Successful", "Guest deleted successfully");
	}

}
