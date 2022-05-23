package it.uniroma3.catering.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.catering.model.Buffet;
import it.uniroma3.catering.model.Piatto;

public interface PiattoRepository extends CrudRepository<Piatto, Long> {

	boolean existsByNome(String nome);
	
}
