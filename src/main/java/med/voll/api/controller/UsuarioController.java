package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.DadosCadastroUsuario;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerUser(@RequestBody @Valid DadosCadastroUsuario dados) {

        var usuario = usuarioRepository.findByLogin(dados.login());

        if (usuario == null) {
            var newUsuario = new Usuario(dados);
            usuarioRepository.save(newUsuario);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Username not available");
    }
}
