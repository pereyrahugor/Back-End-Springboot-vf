package com.portfolio.BackEndSpringBoot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String escuelaEdu;
	private String carreraEdu;
	private String fechaEdu;
	private String imagenEdu;

	//Constructores

	public Educacion() {
	}

	public Educacion(String escuelaEdu, String carreraEdu, String fechaEdu, String imagenEdu) {
		this.escuelaEdu = escuelaEdu;
		this.carreraEdu = carreraEdu;
		this.fechaEdu = fechaEdu;
		this.imagenEdu = imagenEdu;
	}

	//Getters and Setters x Lombok

}
