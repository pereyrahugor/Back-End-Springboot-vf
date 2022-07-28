package com.portfolio.BackEndSpringBoot.Repository;

import com.portfolio.BackEndSpringBoot.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer>{
	public Optional<Experiencia> findByCompaniaExp(String companiaExp);
	public boolean existsByCompaniaExp(String companiaExp);
}