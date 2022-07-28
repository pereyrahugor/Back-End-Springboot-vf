package com.portfolio.BackEndSpringBoot.Controller;

import com.portfolio.BackEndSpringBoot.Dto.ProyectoDto;
import com.portfolio.BackEndSpringBoot.Entity.Proyecto;
import com.portfolio.BackEndSpringBoot.Security.Controller.Mensaje;
import com.portfolio.BackEndSpringBoot.Service.ProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
	@Autowired
	ProyectoService proyectoService;

	@GetMapping("/lista")
	public ResponseEntity<List<Proyecto>> list(){
		List<Proyecto> list = proyectoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
		if(!proyectoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Proyecto proyecto = proyectoService.getOne(id).get();
		return new ResponseEntity(proyecto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!proyectoService.existsById(id)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		proyectoService.delete(id);
		return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	}


	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto){
		if(StringUtils.isBlank(proyectoDto.getNombrePro()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(proyectoService.existsByNombrePro(proyectoDto.getNombrePro()))
			return new ResponseEntity(new Mensaje("Esa proyecto existe"), HttpStatus.BAD_REQUEST);

		Proyecto proyecto = new Proyecto(proyectoDto.getNombrePro(),
				proyectoDto.getDescripcionPro(),
				proyectoDto.getFechaPro(),
				proyectoDto.getImagenPro());
		proyectoService.save(proyecto);

		return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectoDto proyectoDto){
		//Validamos si existe el ID
		if(!proyectoService.existsById(id))
			return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
		//Compara nombre de proyecto
		if(proyectoService.existsByNombrePro(proyectoDto.getNombrePro()) &&
				proyectoService.getByNombrePro(proyectoDto.getNombrePro()).get().getId() != id)
			return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
		//No puede estar vacio
		if(StringUtils.isBlank(proyectoDto.getNombrePro()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		Proyecto proyecto = proyectoService.getOne(id).get();
		proyecto.setNombrePro(proyectoDto.getNombrePro());
		proyecto.setDescripcionPro(proyectoDto.getDescripcionPro());
		proyecto.setFechaPro(proyectoDto.getFechaPro());
		proyecto.setImagenPro(proyectoDto.getImagenPro());

		proyectoService.save(proyecto);
		return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

	}
}