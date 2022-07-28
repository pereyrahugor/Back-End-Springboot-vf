package com.portfolio.BackEndSpringBoot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombreSkill;
	private String porcentajeSkill;
	private String imagenSkill;

	//Constructores

	public Skill() {
	}

	public Skill(String nombreSkill, String porcentajeSkill, String imagenSkill) {
		this.nombreSkill = nombreSkill;
		this.porcentajeSkill = porcentajeSkill;
		this.imagenSkill = imagenSkill;
	}

	//Getters and Setters x Lombok
        
}