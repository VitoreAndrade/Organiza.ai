package Lista.dividas.Organiza.ai.controller;

import Lista.dividas.Organiza.ai.dto.*;
import Lista.dividas.Organiza.ai.model.Dividas;
import Lista.dividas.Organiza.ai.model.Usuario;
import Lista.dividas.Organiza.ai.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario (@RequestBody DadosCadastroUsuarioDto dadosCadastroUsuarioDto){
        return  usuarioService.cadastrar(dadosCadastroUsuarioDto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuarioDto>>listar( Pageable paginacao) {
        return usuarioService.listar(paginacao);

    }
//    @GetMapping
//    public ResponseEntity<List<Dividas>>obterDividas(@PathVariable Usuario user){
//        List<Dividas> dividas = usuarioService.obterDividasPorUsuario(user.getId());
//        return ResponseEntity.ok().build();
//    }


    @DeleteMapping
    @Transactional
    public ResponseEntity excluir(@RequestBody DadosExclusaoUsuarioDto dados){
        return usuarioService.excluir(dados);
    }

    @PutMapping
    public ResponseEntity atualizar (@RequestBody DadosAtualizacaoUsuarioDto dados){
        return usuarioService.atualizar(dados);
    }


}
