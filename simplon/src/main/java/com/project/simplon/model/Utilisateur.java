package com.project.simplon.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// TODO: Auto-generated Javadoc
/**
 * The Class Utilisateur.
 */
// Utilisateur 
@Entity
@Table(name = "utilisateurs")
@EntityListeners(AuditingEntityListener.class)

// Model Class
public class Utilisateur implements Serializable {
	
	/** The id. */
	//Attributs
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	/** The name. */
	@NotBlank
	private String name;
	
	/** The last name. */
	@NotBlank
	private String lastName;
	
	// Getters & Setters
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
}
