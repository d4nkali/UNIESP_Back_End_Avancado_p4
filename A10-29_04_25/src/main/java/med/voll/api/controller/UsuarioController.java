package med.voll.api.controller;

import med.voll.api.domain.usuario.DadosCadastroUsuario;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cadastro_usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public ResponseEntity cadastro (@RequestBody @Validated DadosCadastroUsuario dados) {
		
		var senhaCriptografada = passwordEncoder.encode(dados.senha());
		
		var usuario = new Usuario(dados.login(),senhaCriptografada);
		
		repository.save(usuario);
		
		return null;
		
	}

}
