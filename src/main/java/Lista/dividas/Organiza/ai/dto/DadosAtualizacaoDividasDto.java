package Lista.dividas.Organiza.ai.dto;

import Lista.dividas.Organiza.ai.model.Usuario;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoDividasDto(

        @NotNull
        Long id,
        Long valorTotal,
        Long valorPago,
        Long valorRestante,
        String descricao
) {
}
