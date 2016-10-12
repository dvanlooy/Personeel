package be.vdab.services;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;

public interface WerknemerService {
	
	Werknemer read(long id);
	
	Werknemer zoekHoogsteInRang();
	
	void opslag(Werknemer werknemer, BigDecimal bedrag);
	
	Page<Werknemer> findByJobtitel(Jobtitel jobtitel, Pageable pageable);


}