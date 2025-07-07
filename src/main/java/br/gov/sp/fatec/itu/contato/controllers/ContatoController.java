package br.gov.sp.fatec.itu.contato.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.itu.contato.entities.Contato;
import br.gov.sp.fatec.itu.contato.services.ContatoService;

@CrossOrigin
@RestController
@RequestMapping("contatos")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @GetMapping
    public ResponseEntity<List<Contato>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // metodo que consulta um contato pelos filtros selecionados
    // localhost:8080/contatos/filtros?name=lucas?age=18
    @GetMapping("filtros")
    public ResponseEntity<List<Contato>> getAllByFiltering(@ModelAttribute Contato entity) {
        return ResponseEntity.ok().body(service.getAllContactsByFiltering(entity));
    }


    @PostMapping
    public ResponseEntity<Contato> save(@RequestBody Contato contatos) {
        System.out.println(contatos.toString());
        return ResponseEntity.created(null).body(service.save(contatos));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Contato contatos) {
        service.update(contatos, id);
        return ResponseEntity.noContent().build();

    }

}
