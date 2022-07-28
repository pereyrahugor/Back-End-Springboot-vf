package com.portfolio.BackEndSpringBoot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombrePro;
	private String descripcionPro;
	private String fechaPro;
	private String imagenPro;

	//Constructores

	public Proyecto() {
	}

	public Proyecto(String nombrePro, String descripcionPro, String fechaPro, String imagenPro) {
		this.nombrePro = nombrePro;
		this.descripcionPro = descripcionPro;
		this.fechaPro = fechaPro;
		this.imagenPro = imagenPro;
	}

	//Getters and Setters x Lombok

}