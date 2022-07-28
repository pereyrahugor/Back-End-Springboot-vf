package com.portfolio.BackEndSpringBoot.Controller;

import com.portfolio.BackEndSpringBoot.Entity.Persona;
import com.portfolio.BackEndSpringBoot.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
	@Autowired IPersonaService ipersonaService;

	@GetMapping("/personas/traer")
	public List<Persona> getPersona() {
		return ipersonaService.getPersona();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/personas/crear")
	public String createPersona(@RequestBody Persona persona){
		ipersonaService.savePersona(persona);
		return "La persona fue creada correctamente";
	}

	@DeleteMapping("/personas/borrar/{id}")
	public String deletePersona(@PathVariable Long id){
		ipersonaService.deletePersona(id);
		return "La persona fue eliminada correctamente";
	}

	@PutMapping("/personas/editar/{id}")
	public Persona editPersona(@PathVariable Long id,
							   @RequestParam("nombre") String nuevoNombre,
							   @RequestParam("apellido") String nuevoApellido,
							   @RequestParam("fecha_de_nacimiento") String nuevoFecha_de_nacimiento,
							   @RequestParam("nacionalidad") String nuevoNacionalidad,
							   @RequestParam("mail") String nuevoMail,
							   @RequestParam("sobre_mi") String nuevoSobre_mi,
							   @RequestParam("ocupacion") String nuevoOcupacion,
							   @RequestParam("imagen_background") String nuevoImagen_background,
							   @RequestParam("imagen_perfil") String nuevoImagen_perfil){

		Persona persona = ipersonaService.findPersona(id);
		persona.setNombre(nuevoNombre);
		persona.setApellido(nuevoApellido);
		persona.setFecha_de_nacimiento(nuevoFecha_de_nacimiento);
		persona.setNacionalidad(nuevoNacionalidad);
		persona.setMail(nuevoMail);
		persona.setSobre_mi(nuevoSobre_mi);
		persona.setOcupacion(nuevoOcupacion);
		persona.setImagen_background(nuevoImagen_background);
		persona.setImagen_perfil(nuevoImagen_perfil);

		ipersonaService.savePersona(persona);
		return persona;
	}

	@GetMapping("/personas/traer/perfil")
	public Persona findPersona(){
		return ipersonaService.findPersona((long)1);
	}
}
