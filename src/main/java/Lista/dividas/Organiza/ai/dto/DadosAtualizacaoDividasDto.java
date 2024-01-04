package Lista.dividas.Organiza.ai.dto;

import Lista.dividas.Organiza.ai.model.SituacaoDividas;
import Lista.dividas.Organiza.ai.model.Usuario;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoDividasDto(

        @NotNull
        Long id,
        int valorTotal,
        int valorPago,
        int valorRestante,
        int qtdParcelas,
        String descricao,
        SituacaoDividas situacaoDividas
) {
}
