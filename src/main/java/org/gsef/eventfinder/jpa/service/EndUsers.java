package org.gsef.eventfinder.jpa.service;

import java.util.Optional;

import org.gsef.eventfinder.jpa.model.EndUser;
import org.springframework.data.repository.CrudRepository;

public class EndUsers implements CrudRepository<EndUsers, Long> {
	
	public static EndUser findEndUserByUsername(String username) {
		return new EndUser(1, "test", "{noop}password");
	}

	@Override
	public <S extends EndUsers> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EndUsers> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<EndUsers> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<EndUsers> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<EndUsers> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EndUsers entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends EndUsers> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	

}
