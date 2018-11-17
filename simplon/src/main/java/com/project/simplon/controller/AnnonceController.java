package com.project.simplon.controller;

import com.project.simplon.exception.ResourceNotFoundException;
import com.project.simplon.model.Annonce;
import com.project.simplon.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AnnonceController {

	@Autowired
	AnnonceRepository annonceRepository;

	// GET toutes les annonces

	@GetMapping("/annonces")
	public List<Annonce> getAllAnnonces() {
		return annonceRepository.findAll();
	}

	// Créer une nouvelle annonce

	@PostMapping("/annonces")
	public Annonce createAnnonce(@Valid @RequestBody Annonce annonce) {
		return annonceRepository.save(annonce);
	}

	// GET une annonce avec son id 

	@GetMapping("/annonces/{id}")
	public Annonce getAnnonceById(@PathVariable(value = "id") Long annonceId) {
		return annonceRepository.findById(annonceId)
				.orElseThrow(() -> new ResourceNotFoundException("Annonce", "id", annonceId));
	}


	// UPDATE une annonce avec son id 
	@PutMapping("/annonces/{id}")
	public Annonce updateAnnonce(@PathVariable(value = "id") Long annonceId,
			@Valid @RequestBody Annonce annonceDetails) {

		Annonce annonce = annonceRepository.findById(annonceId)
				.orElseThrow(() -> new ResourceNotFoundException("Annonce", "id", annonceId));

		annonce.setTitle(annonceDetails.getTitle());
		annonce.setDescription(annonceDetails.getDescription());
		annonce.setDate(annonceDetails.getDate());

		Annonce updatedAnnonce = annonceRepository.save(annonce);
		return updatedAnnonce;
	}

	// Supprimer une annonce 
	@DeleteMapping("/annonces/{id}")
	public ResponseEntity<?> deleteAnnonce(@PathVariable(value = "id") Long annonceId) {
		Annonce annonce = annonceRepository.findById(annonceId)
				.orElseThrow(() -> new ResourceNotFoundException("Annonce", "id", annonceId));

		annonceRepository.delete(annonce);

		return ResponseEntity.ok().build();
	}
}
