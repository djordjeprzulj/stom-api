package com.stom.app.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class GrupaIntervencija {

	@Id
	private Integer id;
	
	@Column(nullable=false)
	private String naziv;
	
	@OneToMany(mappedBy="grupaIntervencija")
	@JsonBackReference
	private List<VrstaIntervencije> vrstaIntervencije;
	
	public GrupaIntervencija() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<VrstaIntervencije> getVrstaIntervencije() {
		return vrstaIntervencije;
	}

	public void setVrstaIntervencije(List<VrstaIntervencije> vrstaIntervencije) {
		this.vrstaIntervencije = vrstaIntervencije;
	}

}
