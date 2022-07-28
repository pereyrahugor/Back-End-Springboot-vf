package com.portfolio.BackEndSpringBoot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 45, message = "demasiados caractéres")
	private String nombre;

	@NotNull
	@Size(min = 1, max = 45, message = "demasiados caractéres")
	private String apellido;

	@NotNull
	@Size(min = 1, max = 10, message = "demasiados caractéres")
	private String fecha_de_nacimiento;

	@NotNull
	@Size(min = 1, max = 45, message = "demasiados caractéres")
	private String nacionalidad;

	@NotNull
	@Size(min = 1, max = 45, message = "demasiados caractéres")
	private String mail;

	@NotNull
	@Size(min = 1, max = 200, message = "demasiados caractéres")
	private String sobre_mi;
	@NotNull
	@Size(min = 1, max = 100, message = "demasiados caractéres")
	private String ocupacion;

	@NotNull
	@Size(min = 1, max = 100, message = "demasiados caractéres")
	private String imagen_background;

	@NotNull
	@Size(min = 1, max = 100, message = "demasiados caractéres")
	private String imagen_perfil;

}