package com.algaworks.algafood.jpa;

import com.algaworks.algafood.domain.model.Cozinha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CadastroCozinha {
  /*
    EntityManager é uma interface em JPA que gerencia o contexto de persistencia, ele é responsavel
    pela intermediação dos comandos que são dados pela tradução do sql.
   */
    @PersistenceContext
    private EntityManager manager;

    public List<Cozinha> listar() {
      return manager.createQuery("from Cozinha", Cozinha.class)
              .getResultList();
    }
    public Cozinha buscar(Long id) {
      return manager.find(Cozinha.class, id);
    }

    @Transactional
    public Cozinha adicionar(Cozinha cozinha) {
      return manager.merge(cozinha);
    }
    @Transactional
    public void remover(Cozinha cozinha) {
      cozinha = buscar(cozinha.getId());
      manager.remove(cozinha);

    }

}
