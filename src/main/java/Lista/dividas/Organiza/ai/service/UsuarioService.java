package Lista.dividas.Organiza.ai.service;

import Lista.dividas.Organiza.ai.dto.DadosCadastroUsuarioDto;
import Lista.dividas.Organiza.ai.model.Usuario;
import Lista.dividas.Organiza.ai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public ResponseEntity cadastrar(DadosCadastroUsuarioDto dados){
        var usuario = new Usuario(dados);
        var cadastro = usuarioRepository.save(usuario);
        return ResponseEntity.ok().body(dados);
    }


}
