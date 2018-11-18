package com.project.simplon.controller;

import com.project.simplon.exception.ResourceNotFoundException;
import com.project.simplon.model.Reservation;
import com.project.simplon.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReservationController {

	@Autowired
	ReservationRepository reservationRepository;

	// Get toutes les réservations

	@GetMapping("/reservations")
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	// Post une nouvelle réservation

	@PostMapping("/reservations")
	public Reservation createReservation(@Valid @RequestBody Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	// Get une réservation avec son id

	@GetMapping("/reservations/{id}")
	public Reservation getReservationById(@PathVariable(value = "id") Long reservationId,
			@Valid @RequestBody Reservation reservation) {
		return reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", reservationId));
	}

	// Update une réservation avec son id

	@PutMapping("/reservations/{id}")
	public Reservation updateReservation(@PathVariable(value = "id") Long reservationId,
			@Valid @RequestBody Reservation reservationDetails) {

		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", reservationId));

		reservation.setTitle(reservationDetails.getTitle());
		reservation.setNom_client(reservationDetails.getNom_client());
		reservation.setPrenom_client(reservationDetails.getPrenom_client());
		reservation.setTelephone(reservationDetails.getTelephone());
		reservation.setDate_debut(reservationDetails.getDate_debut());
		reservation.setDate_fin(reservationDetails.getDate_fin());
		reservation.setGain(reservationDetails.getGain());

		Reservation updatedReservation = reservationRepository.save(reservation);
		return updatedReservation;

	}

	// Supprimer une annonce

	@DeleteMapping("/reservations/{id}")
	public ResponseEntity<?> deleteReservation(@PathVariable(value = "id") Long reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", reservationId));

		reservationRepository.delete(reservation);

		return ResponseEntity.ok().build();
	}
}
