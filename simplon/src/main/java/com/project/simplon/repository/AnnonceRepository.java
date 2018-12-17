package com.project.simplon.repository;
import com.project.simplon.model.Annonce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Interface AnnonceRepository.
 */
@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	
	/**
	 * Find by city.
	 *
	 * @param city the city
	 * @return the list
	 */
	List<Annonce> findByCity(String city);

}