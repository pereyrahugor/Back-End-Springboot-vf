package com.portfolio.BackEndSpringBoot.Controller;

import com.portfolio.BackEndSpringBoot.Dto.EducacionDto;
import com.portfolio.BackEndSpringBoot.Entity.Educacion;
import com.portfolio.BackEndSpringBoot.Security.Controller.Mensaje;
import com.portfolio.BackEndSpringBoot.Service.EducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
	@Autowired
	EducacionService educacionService;

	@GetMapping("/lista")
	public ResponseEntity<List<Educacion>> list(){
		List<Educacion> list = educacionService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
		if(!educacionService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Educacion educacion = educacionService.getOne(id).get();
		return new ResponseEntity(educacion, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!educacionService.existsById(id)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		educacionService.delete(id);
		return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	}


	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto){
		if(StringUtils.isBlank(educacionDto.getEscuelaEdu()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(educacionService.existsByEscuelaEdu(educacionDto.getEscuelaEdu()))
			return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);

		Educacion educacion = new Educacion(educacionDto.getEscuelaEdu(),
				educacionDto.getCarreraEdu(),
				educacionDto.getFechaEdu(),
				educacionDto.getImagenEdu());
		educacionService.save(educacion);

		return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducacionDto educacionDto){
		//Validamos si existe el ID
		if(!educacionService.existsById(id))
			return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
		//Compara nombre de educacion
		if(educacionService.existsByEscuelaEdu(educacionDto.getEscuelaEdu()) &&
				educacionService.getByEscuelaEdu(educacionDto.getEscuelaEdu()).get().getId() != id)
			return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
		//No puede estar vacio
		if(StringUtils.isBlank(educacionDto.getEscuelaEdu()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		Educacion educacion = educacionService.getOne(id).get();
		educacion.setEscuelaEdu(educacionDto.getEscuelaEdu());
		educacion.setCarreraEdu(educacionDto.getCarreraEdu());
		educacion.setFechaEdu(educacionDto.getFechaEdu());
		educacion.setImagenEdu(educacionDto.getImagenEdu());

		educacionService.save(educacion);
		return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);

	}
}