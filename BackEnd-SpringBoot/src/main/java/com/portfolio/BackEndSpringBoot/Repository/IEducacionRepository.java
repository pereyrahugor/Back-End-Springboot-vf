package com.portfolio.BackEndSpringBoot.Repository;

import com.portfolio.BackEndSpringBoot.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Integer>{
	public Optional<Educacion> findByEscuelaEdu(String escuelaEdu);
	public boolean existsByEscuelaEdu(String escuelaEdu);
}