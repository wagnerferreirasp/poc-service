package br.com.nextel.pocservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
    List<UsuarioEntity> findAll();
}
