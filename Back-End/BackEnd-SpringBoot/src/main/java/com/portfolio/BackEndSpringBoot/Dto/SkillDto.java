package com.portfolio.BackEndSpringBoot.Dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
@Getter @Setter
public class SkillDto {

	@NotBlank
	private String nombreSkill;
	@NotBlank
	private String porcentajeSkill;
	@NotBlank
	private String imagenSkill;

	//Constructores

	public SkillDto() {
	}

	public SkillDto(String nombreSkill, String porcentajeSkill, String imagenSkill) {
		this.nombreSkill = nombreSkill;
		this.porcentajeSkill = porcentajeSkill;
		this.imagenSkill = imagenSkill;
	}

	//Getters and Setters x Lombok

}