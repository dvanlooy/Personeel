package be.vdab.services;

import java.util.List;

import be.vdab.entities.Jobtitel;

public interface JobtitelService {

	Jobtitel read(long id);

	List<Jobtitel> findAll();

}