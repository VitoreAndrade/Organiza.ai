package Lista.dividas.Organiza.ai.dto;

import Lista.dividas.Organiza.ai.model.Dividas;
import Lista.dividas.Organiza.ai.model.SituacaoDividas;

public record DadosListagemDividaDto(

        Long id,
        int valorTotal,
        int valorPago,
        int valorRestante,
        String descricao,
        SituacaoDividas situacaoDividas
) {
    public DadosListagemDividaDto (Dividas dividas){
        this(dividas.getId(),
                dividas.getValorTotal(),
                dividas.getValorPago(),
                dividas.getValorRestante(),

                dividas.getDescricao(),
                dividas.getSituacao());
    }
}
