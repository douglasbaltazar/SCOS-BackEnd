package com.scos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scos.backend.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
