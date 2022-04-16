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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"matricola"}))
@ NamedQuery (name =  "findAllAllievi", query = "SELECT a FROM Allievo a")
public class Allievo {
	
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
	private String matricola;
	
	@Column(nullable=false)
	private String email;

	@ManyToOne 
	private Societa societa;

	@ManyToMany(mappedBy="allievi")
	private List<Corso> corsiAllievo;
	
	// Metodi getter e setter
	
	public List<Corso> getCorsi() {
		return corsiAllievo;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsiAllievo = corsi;
	}

	public void addCorso (Corso corso) {
		this.corsiAllievo.add(corso);
	}
	
	public boolean removeCorso (Corso corso) {
		return this.corsiAllievo.remove(corso);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Metodi getter e setter

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

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public Long getId() {
		return id;
	}
}
