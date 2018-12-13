package com.project.simplon.controller;

import com.project.simplon.exception.ResourceNotFoundException;
import com.project.simplon.model.Utilisateur;
import com.project.simplon.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UtilisateurController {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	// Récupérer tout les utilisateurs

	@GetMapping("/utilisateurs")
	public List<Utilisateur> getAllUsers() {
		return utilisateurRepository.findAll();

	}

	// Récupérer un utilisateur
	
	@GetMapping("/utilisateurs/{id}")
	public Utilisateur getOneUser(@PathVariable(value = "id") Long utilisateurId) {
		return utilisateurRepository.findById(utilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));
	}

	// Créer un utilisateur

	@PostMapping("/new/utilisateurs")
	public Utilisateur createUser(@Valid @RequestBody Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	// Mettre un utilisateur avec son id
	
	@PutMapping("/utilisateurs/{id}")
	public Utilisateur updateUser(@PathVariable(value = "id") Long utilisateurId,
			@Valid @RequestBody Utilisateur utilisateurDetails) {

		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));

		utilisateur.setLastName(utilisateurDetails.getLastName());
		utilisateur.setName(utilisateurDetails.getName());

		Utilisateur updatedUser = utilisateurRepository.save(utilisateur);
		return updatedUser;
	}

	// Delete un utilisateur avec son id
	
	@DeleteMapping("/utilisateurs/{id}")
	public ResponseEntity<?> deleteAnnonce(@PathVariable(value = "id") Long utilisateurId) {
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));

		utilisateurRepository.delete(utilisateur);

		return ResponseEntity.ok().build();
	}

}
