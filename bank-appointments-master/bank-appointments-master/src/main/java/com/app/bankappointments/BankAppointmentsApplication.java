package com.app.bankappointments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BankAppointmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppointmentsApplication.class, args);
	}

}
