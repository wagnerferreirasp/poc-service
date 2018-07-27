package br.com.nextel.pocservice;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    void insere(UsuarioEntity usuarioEntity);
    List<UsuarioEntity> listaTodos();
    Optional<UsuarioEntity> selecionaPorId(Long id);

    void deleta(UsuarioEntity usuarioEntity);
}
