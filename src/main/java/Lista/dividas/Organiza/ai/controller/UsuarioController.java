package Lista.dividas.Organiza.ai.controller;

import Lista.dividas.Organiza.ai.dto.*;
import Lista.dividas.Organiza.ai.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario (@RequestBody DadosCadastroUsuarioDto dadosCadastroUsuarioDto){
        return  usuarioService.cadastrar(dadosCadastroUsuarioDto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuarioDto>>listar(@PageableDefault(size = 10, sort ={"nome"}) Pageable paginacao) {
        return usuarioService.listar(paginacao);

    }

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
