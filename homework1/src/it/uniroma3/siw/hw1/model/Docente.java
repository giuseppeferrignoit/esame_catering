package it.uniroma3.siw.hw1.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"partitaIva"}))
public class Docente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	@Column(nullable=false)
	private LocalDate dataNascita;
	
	@Column(nullable=false)
	private String luogoNascita;
	
	@Column(nullable=false)
	private Integer partitaIva;
	
	@OneToMany (mappedBy="docente", fetch=FetchType.EAGER) 
	private List<Corso> corsiDocente;
	
	// Metodi getter e setter
	
	public void addCorso (Corso corso) {
		this.corsiDocente.add(corso);
	}
	
	public boolean removeCorso (Corso corso) {
		return this.corsiDocente.remove(corso);
	}

	public List<Corso> getCorsi() {
		return corsiDocente;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsiDocente = corsi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public Integer getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(Integer partitaIva) {
		this.partitaIva = partitaIva;
	}

	public Long getId() {
		return id;
	}
}
