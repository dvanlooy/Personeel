package be.vdab.services;

import java.math.BigDecimal;

import be.vdab.entities.Werknemer;
import be.vdab.repositories.WerknemerRepository;

@ReadOnlyTransactionalService
public class WerknemerServiceImpl implements WerknemerService {

	private WerknemerRepository werknemerRepository;

	public WerknemerServiceImpl(WerknemerRepository werknemerRepository) {
		this.werknemerRepository = werknemerRepository;
	}

	@Override
	public Werknemer read(long id) {
		return werknemerRepository.findOne(id);
	}

	@Override
	public Werknemer zoekHoogsteInRang() {
		return werknemerRepository.findByChefIsNull();
	}

	/**
	 * Telt bedrag op bij het salaris
	 */
	@Override
	@ModifyingTransactionalServiceMethod
	public void opslag(Werknemer werknemer, BigDecimal bedrag) {
		werknemer.setSalaris(werknemer.getSalaris().add(bedrag));
		werknemerRepository.save(werknemer);

	}
}
