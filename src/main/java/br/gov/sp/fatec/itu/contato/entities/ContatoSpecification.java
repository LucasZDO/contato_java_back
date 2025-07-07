package br.gov.sp.fatec.itu.contato.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class ContatoSpecification {

    // metodo que converte uma entidade para uma serie de filtros aplicaveis no
    // repository
    public static Specification<Contato> convertEntityToSpecification(Contato entity) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (entity.getName() != null) {
                predicates.add(cb.like(root.get("name"), "%" + entity.getName() + "%"));
            }

            if (entity.getTelephone() != null) {
                predicates.add(cb.like(root.get("telephone"), "%" + entity.getTelephone() + "%"));
            }

            if (entity.getEmail() != null) {
                predicates.add(cb.like(root.get("email"), "%" + entity.getEmail() + "%"));
            }
            if (entity.getAge() != null) {
                predicates.add(cb.like(root.get("age"), "%" + entity.getAge() + "%"));
            }

            if (entity.getMaritalStatus() != null) {
                predicates.add(cb.like(root.get("maritalStatus"), "%" + entity.getMaritalStatus() + "%"));
            }

            if (entity.getRg() != null) {
                predicates.add(cb.like(root.get("rg"), "%" + entity.getCpf() + "%"));
            }

            if (entity.getCpf() != null) {
                predicates.add(cb.like(root.get("cpf"), "%" + entity.getCpf() + "%"));
            }

            if (entity.getProfession() != null) {
                predicates.add(cb.like(root.get("profession"), "%" + entity.getProfession() + "%"));
            }

            if (entity.getAddress() != null) {
                predicates.add(cb.like(root.get("address"), "%" + entity.getAddress() + "%"));
            }

            if (entity.getDateOfBirth() != null) {
                predicates.add(cb.like(root.get("dateOfBirth"), "%" + entity.getDateOfBirth() + "%"));
            }

            if (entity.getCategory() != null) {
                predicates.add(cb.like(root.get("category"), "%" + entity.getCategory() + "%"));
            }

            if (entity.getFavorite() != null) {
                predicates.add(cb.equal(root.get("favorite"), entity.getFavorite()));
            }
            
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
