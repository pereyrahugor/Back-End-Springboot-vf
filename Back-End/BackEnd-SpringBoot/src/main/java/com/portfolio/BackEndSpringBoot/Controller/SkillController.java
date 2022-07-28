package com.portfolio.BackEndSpringBoot.Controller;

import com.portfolio.BackEndSpringBoot.Dto.SkillDto;
import com.portfolio.BackEndSpringBoot.Entity.Skill;
import com.portfolio.BackEndSpringBoot.Security.Controller.Mensaje;
import com.portfolio.BackEndSpringBoot.Service.SkillService;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
	@Autowired
	SkillService skillService;

	@GetMapping("/lista")
	public ResponseEntity<List<Skill>> list(){
		List<Skill> list = skillService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Skill> getById(@PathVariable("id") int id){
		if(!skillService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Skill skill = skillService.getOne(id).get();
		return new ResponseEntity(skill, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!skillService.existsById(id)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		skillService.delete(id);
		return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	}


	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody SkillDto skillDto){
		if(StringUtils.isBlank(skillDto.getNombreSkill()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(skillService.existsByNombreSkill(skillDto.getNombreSkill()))
			return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);

		Skill skill = new Skill(skillDto.getNombreSkill(),
				skillDto.getPorcentajeSkill(),
				skillDto.getImagenSkill());
		skillService.save(skill);

		return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillDto skillDto){
		//Validamos si existe el ID
		if(!skillService.existsById(id))
			return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
		//Compara nombre de skill
		if(skillService.existsByNombreSkill(skillDto.getNombreSkill()) &&
				skillService.getByNombreSkill(skillDto.getNombreSkill()).get().getId() != id)
			return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
		//No puede estar vacio
		if(StringUtils.isBlank(skillDto.getNombreSkill()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		Skill skill = skillService.getOne(id).get();
		skill.setNombreSkill(skillDto.getNombreSkill());
		skill.setPorcentajeSkill(skillDto.getPorcentajeSkill());
		skill.setImagenSkill(skillDto.getImagenSkill());

		skillService.save(skill);
		return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

	}
}