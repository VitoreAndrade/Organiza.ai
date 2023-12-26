package Lista.dividas.Organiza.ai.controller;

import Lista.dividas.Organiza.ai.dto.DadosCadastroUsuarioDto;
import Lista.dividas.Organiza.ai.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class controller {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario (@RequestBody DadosCadastroUsuarioDto dadosCadastroUsuarioDto){
        return  usuarioService.cadastrar(dadosCadastroUsuarioDto);
    }



}
