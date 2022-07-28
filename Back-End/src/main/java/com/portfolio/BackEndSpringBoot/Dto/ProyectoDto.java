package com.portfolio.BackEndSpringBoot.Dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
@Getter @Setter
public class ProyectoDto {

	@NotBlank
	private String nombrePro;
	@NotBlank
	private String descripcionPro;
	@NotBlank
	private String fechaPro;
	@NotBlank
	private String imagenPro;

	//Constructores

	public ProyectoDto() {
	}

	public ProyectoDto(String nombrePro, String descripcionPro, String fechaPro, String imagenPro) {
		this.nombrePro = nombrePro;
		this.descripcionPro = descripcionPro;
		this.fechaPro = fechaPro;
		this.imagenPro = imagenPro;
	}

//Getters and setters x Lombok

}