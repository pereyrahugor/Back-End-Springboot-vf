package com.portfolio.BackEndSpringBoot.Dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
@Getter @Setter
public class EducacionDto {

	@NotBlank
	private String escuelaEdu;
	@NotBlank
	private String carreraEdu;
	@NotBlank
	private String fechaEdu;
	@NotBlank
	private String imagenEdu;

	//Constructores

	public EducacionDto() {
	}

	public EducacionDto(String escuelaEdu, String carreraEdu, String fechaEdu, String imagenEdu) {
		this.escuelaEdu = escuelaEdu;
		this.carreraEdu = carreraEdu;
		this.fechaEdu = fechaEdu;
		this.imagenEdu = imagenEdu;
	}

	//Getters and setters x Lombok

}