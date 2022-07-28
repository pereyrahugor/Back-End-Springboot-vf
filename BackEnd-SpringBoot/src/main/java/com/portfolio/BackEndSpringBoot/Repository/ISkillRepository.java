package com.portfolio.BackEndSpringBoot.Repository;

import com.portfolio.BackEndSpringBoot.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer>{
	public Optional<Skill> findByNombreSkill(String nombreSkill);
	public boolean existsByNombreSkill(String nombreSkill);
}
