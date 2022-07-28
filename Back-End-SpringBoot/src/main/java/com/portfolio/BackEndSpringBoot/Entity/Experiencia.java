package com.portfolio.BackEndSpringBoot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String companiaExp;
	private String posicionExp;
	private String modalidadExp;
	private String inicioExp;
	private String finExp;
	private String imagenExp;

	//Constructores

	public Experiencia() {
	}

	public Experiencia(String companiaExp, String posicionExp, String modalidadExp, String inicioExp, String finExp, String imagenExp) {
		this.companiaExp = companiaExp;
		this.posicionExp = posicionExp;
		this.modalidadExp = modalidadExp;
		this.inicioExp = inicioExp;
		this.finExp = finExp;
		this.imagenExp = imagenExp;
	}

	//Getters and Setters x Lombok

}