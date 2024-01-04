package Lista.dividas.Organiza.ai.service;

import Lista.dividas.Organiza.ai.dto.*;
import Lista.dividas.Organiza.ai.model.Dividas;
import Lista.dividas.Organiza.ai.model.SituacaoDividas;
import Lista.dividas.Organiza.ai.model.Usuario;
import Lista.dividas.Organiza.ai.repository.DividasRepository;
import Lista.dividas.Organiza.ai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DividasService {
    @Autowired
    private DividasRepository dividasRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

        public ResponseEntity cadastrar (DadosCadastroDividasDto dados) {
            var dividas = new Dividas(dados);
            var usuario = usuarioRepository.getReferenceById(dados.idUsuario().getId());

            if (dividas.getValorPago() >=0) {
                var valorFalta = dividas.getValorTotal() - dividas.getValorPago();
                dividas.setValorRestante(valorFalta);
            }

            if (dividas.getValorPago() == dividas.getValorTotal()) {
                var valorFalta = dividas.getValorTotal() - dividas.getValorPago();
                dividas.setValorRestante(valorFalta);
                dividas.setSituacao(SituacaoDividas.PAGO);
            } else {
                dividas.setSituacao(SituacaoDividas.A_PAGAR);
            }
            if(usuario.isAtivo() == false){
                dividas.setSituacao(SituacaoDividas.DEVEDOR);
            }
            dividasRepository.save(dividas);


            return ResponseEntity.ok().body(dividas);

        }

    public ResponseEntity<Page<DadosListagemDividaDto>> listar(Pageable paginacao) {
        var page = dividasRepository.findAllByAtivoTrue(paginacao).map(dividas -> new DadosListagemDividaDto(dividas));
        return ResponseEntity.ok(page);
    }

    public ResponseEntity atualizar(DadosAtualizacaoDividasDto dados) {
        Dividas dividaAtualiza = dividasRepository.findById(dados.id()).get();

        var dividas = dividasRepository.findById(dados.id());

        if (dividas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (dados.descricao() != null) {
            dividaAtualiza.setDescricao(dados.descricao());
        }
        if (dados.valorPago() >= 0 || dividaAtualiza.getValorPago() == dividaAtualiza.getValorTotal()) {
            dividaAtualiza.setValorPago(dados.valorPago() + dividaAtualiza.getValorPago());
            dividaAtualiza.setValorRestante(dividaAtualiza.getValorRestante() - dados.valorPago());

        }
        if(dividaAtualiza.getValorRestante() == 0){
            dividaAtualiza.setSituacao(SituacaoDividas.PAGO);
            dividaAtualiza.setAtivo(false);
        }
        if(dividaAtualiza.getValorRestante() <0){
            dividaAtualiza.setValorPago(dividaAtualiza.getValorPago());
            throw new RuntimeException("Divida ja paga!");
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
