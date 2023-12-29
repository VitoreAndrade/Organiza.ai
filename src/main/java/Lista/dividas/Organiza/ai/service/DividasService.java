package Lista.dividas.Organiza.ai.service;

import Lista.dividas.Organiza.ai.dto.*;
import Lista.dividas.Organiza.ai.model.Dividas;
import Lista.dividas.Organiza.ai.model.Usuario;
import Lista.dividas.Organiza.ai.repository.DividasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DividasService {
    @Autowired
    private DividasRepository dividasRepository;

    public ResponseEntity cadastrar (DadosCadastroDividasDto dados){
        var dividas = new Dividas(dados);
        var cadastroDivida = dividasRepository.save(dividas);
        return ResponseEntity.ok().body(dados);
    }
    public ResponseEntity<Page<DadosListagemDividaDto>> listar(Pageable paginacao) {
        var page = dividasRepository.findAllByAtivoTrue(paginacao).map(dividas -> new DadosListagemDividaDto(dividas));
        return ResponseEntity.ok(page);
    }

    public ResponseEntity atualizar(DadosAtualizacaoDividasDto dados){
        Dividas dividaAtualiza = dividasRepository.findById(dados.id()).get();

        var dividas = dividasRepository.findById(dados.id());

        if(dividas.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        if(dados.descricao() != null){
            dividaAtualiza.setDescricao(dados.descricao());
        }
        if(dados.valorTotal() != null){
            dividaAtualiza.setValorTotal(dados.valorTotal());
        }
        if(dados.valorPago() != null){
            dividaAtualiza.setValorPago(dados.valorPago());
        }
        if(dados.valorRestante() != null){
            dividaAtualiza.setValorRestante(dados.valorRestante());
        }
        dividasRepository.saveAndFlush(dividaAtualiza);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity excluir (DadosExclusaoDividaDto dados){
        var excluirDivida = dividasRepository.getReferenceById(dados.id());
        excluirDivida.excluir();
        return ResponseEntity.noContent().build();
    }

}
