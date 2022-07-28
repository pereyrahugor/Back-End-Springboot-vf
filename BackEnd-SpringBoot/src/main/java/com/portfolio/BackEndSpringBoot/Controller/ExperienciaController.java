package com.portfolio.BackEndSpringBoot.Controller;

import com.portfolio.BackEndSpringBoot.Dto.ExperienciaDto;
import com.portfolio.BackEndSpringBoot.Entity.Experiencia;
import com.portfolio.BackEndSpringBoot.Security.Controller.Mensaje;
import com.portfolio.BackEndSpringBoot.Service.ExperienciaService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
	@Autowired
	ExperienciaService experienciaService;

	@GetMapping("/lista")
	public ResponseEntity<List<Experiencia>> list(){
		List<Experiencia> list = experienciaService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
		if(!experienciaService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Experiencia experiencia = experienciaService.getOne(id).get();
		return new ResponseEntity(experiencia, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!experienciaService.existsById(id)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		experienciaService.delete(id);
		return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	}


	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto){
		if(StringUtils.isBlank(experienciaDto.getCompaniaExp()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(experienciaService.existsByCompaniaExp(experienciaDto.getCompaniaExp()))
			return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);

		Experiencia experiencia = new Experiencia(experienciaDto.getCompaniaExp(),
				experienciaDto.getPosicionExp(),
				experienciaDto.getModalidadExp(),
				experienciaDto.getInicioExp(),
				experienciaDto.getFinExp(),
				experienciaDto.getImagenExp());
		experienciaService.save(experiencia);

		return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto experienciaDto){
		//Validamos si existe el ID
		if(!experienciaService.existsById(id))
			return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
		//Compara nombre de experiencias
		if(experienciaService.existsByCompaniaExp(experienciaDto.getCompaniaExp()) &&
				experienciaService.getByCompaniaExp(experienciaDto.getCompaniaExp()).get().getId() != id)
			return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
		//No puede estar vacio
		if(StringUtils.isBlank(experienciaDto.getCompaniaExp()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		Experiencia experiencia = experienciaService.getOne(id).get();
		experiencia.setCompaniaExp(experienciaDto.getCompaniaExp());
		experiencia.setPosicionExp(experienciaDto.getPosicionExp());
		experiencia.setModalidadExp(experienciaDto.getModalidadExp());
		experiencia.setInicioExp(experienciaDto.getInicioExp());
		experiencia.setFinExp(experienciaDto.getFinExp());
		experiencia.setImagenExp(experienciaDto.getImagenExp());

		experienciaService.save(experiencia);
		return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

	}
}