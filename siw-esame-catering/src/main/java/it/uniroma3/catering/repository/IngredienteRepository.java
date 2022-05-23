package it.uniroma3.catering.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.catering.model.Ingrediente;
import it.uniroma3.catering.model.Piatto;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {

	boolean existsByNome(String nome);

}
