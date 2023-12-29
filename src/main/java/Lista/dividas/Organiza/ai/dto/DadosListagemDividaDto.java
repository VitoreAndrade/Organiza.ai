package Lista.dividas.Organiza.ai.dto;

import Lista.dividas.Organiza.ai.model.Dividas;

public record DadosListagemDividaDto(

        Long valorTotal,
        Long valorPago,
        Long valorRestante,
        int qtdParcelas,
        String descricao
) {
    public DadosListagemDividaDto (Dividas dividas){
        this(dividas.getValorTotal(),
                dividas.getValorPago(),
                dividas.getValorRestante(),
                dividas.getQtdParcelas(),
                dividas.getDescricao());
    }
}
