package it.uniroma3.catering.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.catering.model.Buffet;
import it.uniroma3.catering.model.Chef;

public interface BuffetRepository extends CrudRepository<Buffet, Long> {
	
	/*
	 * Possiamo inserire, in aggiunta ai metodi dell'interfaccia, 
	 * delle query che servono all'applicazione
	*/
	
	List<Buffet> findAllByChef(Chef chef);

	boolean existsByNome(String nome);
	
}
