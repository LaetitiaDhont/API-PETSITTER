package com.project.simplon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.simplon.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
