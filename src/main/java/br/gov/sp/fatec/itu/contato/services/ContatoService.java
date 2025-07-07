package br.gov.sp.fatec.itu.contato.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.itu.contato.entities.Contato;
import br.gov.sp.fatec.itu.contato.entities.ContatoSpecification;
import br.gov.sp.fatec.itu.contato.repository.ContatosRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatoService {

    @Autowired
    private ContatosRepository repository;

    public List<Contato> getAll() {
        return repository.findAll();
    }

    // metodo que salva um novo contato
    public Contato save(Contato contatos) {
        return repository.save(contatos);
    }

    public void update(Contato contatos, long id) {
        Contato aux = repository.getReferenceById(id);

        aux.setFavorite(contatos.getFavorite());
        aux.setCategory(contatos.getCategory());
        aux.setDateOfBirth(contatos.getDateOfBirth());
        aux.setAddress(contatos.getAddress());
        aux.setProfession(contatos.getProfession());
        aux.setCpf(contatos.getCpf());
        aux.setRg(contatos.getRg());
        aux.setMaritalStatus(contatos.getMaritalStatus());
        aux.setAge(contatos.getAge());
        aux.setEmail(contatos.getEmail());
        aux.setTelephone(contatos.getTelephone());
        aux.setName(contatos.getName());

        repository.save(aux);
    }

    public void delete(long id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }


    public List<Contato> getAllContactsByFiltering(Contato listaDeFiltros) {

        // pegar os filtros e para cada filtro eu devo passar para o repository
        // transforma a entidade em uma lista de filtros
        Specification<Contato> filtros = ContatoSpecification.convertEntityToSpecification(listaDeFiltros);

        // chama o repository e retorna o resultado
        return repository.findAll(filtros);
    }

}
