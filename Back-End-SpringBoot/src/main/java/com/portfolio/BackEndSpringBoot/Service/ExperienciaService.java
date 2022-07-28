package com.portfolio.BackEndSpringBoot.Service;

import com.portfolio.BackEndSpringBoot.Entity.Experiencia;
import com.portfolio.BackEndSpringBoot.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
	@Autowired
	IExperienciaRepository iExperienciaRepository;

	public List<Experiencia> list(){
		return iExperienciaRepository.findAll();
	}

	public Optional<Experiencia> getOne(int id){
		return iExperienciaRepository.findById(id);
	}

	public Optional<Experiencia> getByCompaniaExp(String companiaExp){
		return iExperienciaRepository.findByCompaniaExp(companiaExp);
	}

	public void save(Experiencia experiencia){
		iExperienciaRepository.save(experiencia);
	}

	public void delete(int id){
		iExperienciaRepository.deleteById(id);
	}

	public boolean existsById(int id){
		return iExperienciaRepository.existsById(id);
	}

	public boolean existsByCompaniaExp(String companiaExp){
		return iExperienciaRepository.existsByCompaniaExp(companiaExp);
	}
}