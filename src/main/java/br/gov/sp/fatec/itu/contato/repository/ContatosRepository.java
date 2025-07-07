package br.gov.sp.fatec.itu.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.gov.sp.fatec.itu.contato.entities.Contato;

public interface ContatosRepository extends JpaRepository<Contato, Long>, JpaSpecificationExecutor<Contato> {

}
