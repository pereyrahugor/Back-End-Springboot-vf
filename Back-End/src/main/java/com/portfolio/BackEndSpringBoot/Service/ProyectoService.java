package com.portfolio.BackEndSpringBoot.Service;

import com.portfolio.BackEndSpringBoot.Entity.Proyecto;
import com.portfolio.BackEndSpringBoot.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
	@Autowired
	IProyectoRepository iProyectoRepository;

	public List<Proyecto> list(){
		return iProyectoRepository.findAll();
	}

	public Optional<Proyecto> getOne(int id){
		return iProyectoRepository.findById(id);
	}

	public Optional<Proyecto> getByNombrePro(String nombrePro){
		return iProyectoRepository.findByNombrePro(nombrePro);
	}

	public void save(Proyecto proyecto){
		iProyectoRepository.save(proyecto);
	}

	public void delete(int id){
		iProyectoRepository.deleteById(id);
	}

	public boolean existsById(int id){
		return iProyectoRepository.existsById(id);
	}

	public boolean existsByNombrePro(String nombrePro){
		return iProyectoRepository.existsByNombrePro(nombrePro);
	}
}