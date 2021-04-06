package com.scos.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scos.backend.model.Tecnico;


@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
	@Query(value = "SELECT * FROM tbl_tecnicos WHERE numatendimentos < 2;", nativeQuery=true)
	List<Tecnico> findTecnicosDisponiveis();
}
