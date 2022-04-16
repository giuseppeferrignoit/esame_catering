package it.uniroma3.siw.hw1.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@ NamedQuery (name =  "findAllCorsi", query = "SELECT c FROM Corso c")
public class Corso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private LocalDate dataInizio;
	
	@Column(nullable=false)
	private Integer durataMesi;
	
	// Sulla tabella Corso è creata una colonna con FK docente
	@ManyToOne
	private Docente docente;
	
	@ManyToMany
	private List<Allievo> allievi;
	
	// Metodi getter e setter
	
	public void addallievo (Allievo allievo) {
		this.allievi.add(allievo);
	}
	
	public boolean removeAllievo (Allievo allievo) {
		return this.allievi.remove(allievo);
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Integer getDurataMesi() {
		return durataMesi;
	}

	public void setDurataMesi(Integer durata) {
		this.durataMesi = durata;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Long getId() {
		return id;
	}
	
}
