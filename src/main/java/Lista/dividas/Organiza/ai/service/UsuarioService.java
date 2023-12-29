package Lista.dividas.Organiza.ai.service;

import Lista.dividas.Organiza.ai.dto.DadosAtualizacaoUsuarioDto;
import Lista.dividas.Organiza.ai.dto.DadosCadastroUsuarioDto;
import Lista.dividas.Organiza.ai.dto.DadosExclusaoUsuarioDto;
import Lista.dividas.Organiza.ai.dto.DadosListagemUsuarioDto;
import Lista.dividas.Organiza.ai.model.Usuario;
import Lista.dividas.Organiza.ai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


//    public ResponseEntity<Page<DadosListagemUsuarioDto>> listar(Pageable paginacao) {
//        var page = usuarioRepository.findAllByAtivoTrue  (paginacao).map(DadosListagemUsuarioDto::new);
//        return ResponseEntity.ok(page);
//    }
    public ResponseEntity<Page<DadosListagemUsuarioDto>> listar(Pageable paginacao) {
        var page = usuarioRepository.findAllByAtivoTrue(paginacao).map(usuario -> new DadosListagemUsuarioDto(usuario));
        return ResponseEntity.ok(page);
    }


    public ResponseEntity atualizar(DadosAtualizacaoUsuarioDto dados){
        Usuario usuarioAtuliza = usuarioRepository.findById(dados.idUsuario()).get();
        var usuario = usuarioRepository.findById(dados.idUsuario());
        if(usuario.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        if(dados.nome() != null){
            usuarioAtuliza.setNome(dados.nome());
        }
        if(dados.email() != null){
            usuarioAtuliza.setEmail(dados.email());
        }
        var usuarios = usuarioRepository.saveAndFlush(usuarioAtuliza);

        return ResponseEntity.ok().body(usuarios);

    }

    public ResponseEntity excluir (DadosExclusaoUsuarioDto dados){
        var excluirUsuario = usuarioRepository.getReferenceById(dados.idUsuario());
        excluirUsuario.excluir();
        return ResponseEntity.noContent().build();
    }
}
