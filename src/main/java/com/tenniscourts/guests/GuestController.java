package com.tenniscourts.guests;

import java.util.List;

import com.tenniscourts.guests.manager.GuestManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenniscourts.guests.manager.GuestManager;
import com.tenniscourts.guests.model.ServiceResponse;
/* controller for handling guest members */
@RestController
@RequestMapping("/api/v1/guest")
public class GuestController {

	@Autowired
	@Qualifier("guestManager")
	GuestManager guestManager;

	@GetMapping("/all")
	public ResponseEntity<List<Guest>> getGuests() {
		List<Guest> guests = guestManager.getGuests();
		return new ResponseEntity<>(guests, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ServiceResponse> addGuest(@RequestBody Guest guest) {
		ServiceResponse serviceResponse = guestManager.addGuest(guest);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Guest> getGuest(@PathVariable Long id) {
		Guest guest = guestManager.getGuest(id);
		return new ResponseEntity<>(guest, HttpStatus.OK);
	}

	@GetMapping(path ="/name/{name}")
	public ResponseEntity<Guest> getGuest(@PathVariable String name) {
		Guest guest = guestManager.getGuest(name);
		return new ResponseEntity<>(guest, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ServiceResponse> updateGuest(@RequestBody Guest guest) {
		ServiceResponse serviceResponse = guestManager.updateGuest(guest);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}

	@DeleteMapping(path="/{id}")
	public ResponseEntity<ServiceResponse> deleteGuest(@PathVariable Long id) {
		ServiceResponse serviceResponse = guestManager.deleteGuest(id);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}

}
