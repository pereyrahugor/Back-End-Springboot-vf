package com.portfolio.BackEndSpringBoot.Repository;

import com.portfolio.BackEndSpringBoot.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer>{
	public Optional<Proyecto> findByNombrePro(String nombrePro);
	public boolean existsByNombrePro(String nombrePro);
}