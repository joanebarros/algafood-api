package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

// Essa anotação diz que a interface que esta sendo anotada não deve ser levada em conta para fim de instanciação
@NoRepositoryBean // de um repositorio pelo spring data JPA, ele deve ignora.
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> {

    Optional<T> buscarPrimeiro();
}
