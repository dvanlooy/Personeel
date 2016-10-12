package be.vdab.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {

	Werknemer findByChefIsNull();

	Page<Werknemer> findByJobtitel(Jobtitel jobtitel, Pageable pageable);

}
