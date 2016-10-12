package be.vdab.services;

import java.util.List;

import org.springframework.data.domain.Sort;

import be.vdab.entities.Jobtitel;
import be.vdab.repositories.JobtitelRepository;

@ReadOnlyTransactionalService
public class JobtitelServiceImpl implements JobtitelService {

	private JobtitelRepository jobtitelRepository;

	public JobtitelServiceImpl(JobtitelRepository jobtitelRepository) {
		this.jobtitelRepository = jobtitelRepository;
	}

	@Override
	public Jobtitel read(long id) {
		return jobtitelRepository.findOne(id);
	}


	@Override
	public List<Jobtitel> findAll() {
		return jobtitelRepository.findAll(new Sort("id"));
	}


}
