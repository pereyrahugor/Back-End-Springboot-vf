package com.portfolio.BackEndSpringBoot.Service;

import com.portfolio.BackEndSpringBoot.Entity.Educacion;
import com.portfolio.BackEndSpringBoot.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
	@Autowired
	IEducacionRepository iEducacionRepository;

	public List<Educacion> list(){
		return iEducacionRepository.findAll();
	}

	public Optional<Educacion> getOne(int id){
		return iEducacionRepository.findById(id);
	}

	public Optional<Educacion> getByEscuelaEdu(String escuelaEdu){
		return iEducacionRepository.findByEscuelaEdu(escuelaEdu);
	}

	public void save(Educacion experiencia){
		iEducacionRepository.save(experiencia);
	}

	public void delete(int id){
		iEducacionRepository.deleteById(id);
	}

	public boolean existsById(int id){
		return iEducacionRepository.existsById(id);
	}

	public boolean existsByEscuelaEdu(String escuelaEdu){
		return iEducacionRepository.existsByEscuelaEdu(escuelaEdu);
	}
}