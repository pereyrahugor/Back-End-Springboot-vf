package com.portfolio.BackEndSpringBoot.Dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
@Getter @Setter
public class ExperienciaDto {
	@NotBlank
	private String companiaExp;
	@NotBlank
	private String posicionExp;
	@NotBlank
	private String modalidadExp;
	@NotBlank
	private String inicioExp;
	@NotBlank
	private String finExp;
	@NotBlank
	private String imagenExp;

	//Constructores

	public ExperienciaDto() {
	}

	public ExperienciaDto(String companiaExp, String posicionExp, String modalidadExp, String inicioExp, String finExp, String imagenExp) {
		this.companiaExp = companiaExp;
		this.posicionExp = posicionExp;
		this.modalidadExp = modalidadExp;
		this.inicioExp = inicioExp;
		this.finExp = finExp;
		this.imagenExp = imagenExp;
	}

	//Getters and setters x Lombok

}