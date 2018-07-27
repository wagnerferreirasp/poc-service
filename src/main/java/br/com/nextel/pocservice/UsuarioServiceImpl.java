package br.com.nextel.pocservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repository;

    @Override
    public void insere(UsuarioEntity usuarioEntity) {
        repository.save(usuarioEntity);
    }

    @Override
    public List<UsuarioEntity> listaTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<UsuarioEntity> selecionaPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleta(UsuarioEntity usuarioEntity) {
        repository.delete(usuarioEntity);
    }
}
