package Lista.dividas.Organiza.ai.controller;

import Lista.dividas.Organiza.ai.dto.DadosAtualizacaoDividasDto;
import Lista.dividas.Organiza.ai.dto.DadosCadastroDividasDto;
import Lista.dividas.Organiza.ai.dto.DadosExclusaoDividaDto;
import Lista.dividas.Organiza.ai.model.Dividas;
import Lista.dividas.Organiza.ai.service.DividasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dividas")
@CrossOrigin(origins = "http://localhost:5173")
public class DividasController {

    @Autowired
    private DividasService dividasService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar (@RequestBody DadosCadastroDividasDto dados){
        return dividasService.cadastrar(dados);
    }

    @GetMapping
    @Transactional
    public ResponseEntity listar (@PageableDefault(size = 10, sort ={"descricao"}) Pageable paginacao){
        return dividasService.listar(paginacao);
    }
@GetMapping("/{idUsuario}/dividas")
public List<Dividas> obterUsuarioComDividas(@PathVariable Long idUsuario) {
    return dividasService.obterUsuarioComDividas(idUsuario);

}


    @PutMapping
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoDividasDto dados){
        return dividasService.atualizar(dados);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity exlcuir(@RequestBody DadosExclusaoDividaDto dados){
        return dividasService.excluir(dados);
    }


}
