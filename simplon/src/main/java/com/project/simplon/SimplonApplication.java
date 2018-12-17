package com.project.simplon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// TODO: Auto-generated Javadoc
/**
 * The Class SimplonApplication.
 */
@SpringBootApplication
@EnableJpaAuditing
public class SimplonApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SimplonApplication.class, args);
	}
}
