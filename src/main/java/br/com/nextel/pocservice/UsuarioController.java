package br.com.nextel.pocservice;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @PostMapping(value = "/usuario/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<String> insere(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setNome(usuarioDTO.getNome());
        entity.setIdade(usuarioDTO.getIdade());
        entity.setNomeDaMae(usuarioDTO.getNomeDaMae());

        service.insere(entity);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário cadastrado!");
    }

    @GetMapping(value = "/usuario/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<UsuarioEntity> lista() {
        return service.listaTodos();
    }

    @DeleteMapping(value = "/usuario/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deletado com sucesso"),
            @ApiResponse(code = 412, message = "Usuario nao existe")
    })
    @ResponseBody
    public ResponseEntity<String> deleta(@PathVariable Long id) {
        Optional<UsuarioEntity> optional = service.selecionaPorId(id);
        if (optional.isPresent()) {
            service.deleta(optional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado!");
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Usuario nao existe!");
        }
    }
}
