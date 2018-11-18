package com.project.simplon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.simplon.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation,Long>{

}
