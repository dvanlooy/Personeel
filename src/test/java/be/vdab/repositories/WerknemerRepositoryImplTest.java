package be.vdab.repositories;

import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.datasource.TestDataSourceConfig;
import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestDataSourceConfig.class, TestRepositoriesConfig.class, })
@Transactional // omringt elke test met een transactie, na de test rollback
public class WerknemerRepositoryImplTest {
	@Autowired
	private WerknemerRepository werknemerRepository;

	@Autowired
	private JobtitelRepository jobtitelRepository;

	private Jobtitel jobtitel;

	@Before
	public void before() {
		jobtitel = new Jobtitel("werknemer");
		jobtitelRepository.save(jobtitel);

	}

	@Test
	public void create() {
		Werknemer werknemer = new Werknemer("John", "Doe", null, "email@email.org", jobtitel, BigDecimal.valueOf(1000));
		werknemerRepository.save(werknemer);
		assertNotEquals(0, werknemer.getId());
	}
}