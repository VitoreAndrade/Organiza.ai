package Lista.dividas.Organiza.ai.dto;

import Lista.dividas.Organiza.ai.model.Dividas;

public record DadosListagemDividaDto(

        int valorTotal,
        int valorPago,
        int valorRestante,

        String descricao
) {
    public DadosListagemDividaDto (Dividas dividas){
        this(dividas.getValorTotal(),
                dividas.getValorPago(),
                dividas.getValorRestante(),

                dividas.getDescricao());
    }
}
