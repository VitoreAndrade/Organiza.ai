package Lista.dividas.Organiza.ai.dto;

import Lista.dividas.Organiza.ai.model.Usuario;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroDividasDto(
       @NotNull
       Usuario idUsuario,
       @NotNull
       int valorTotal,
       @NotNull
       int valorPago,
//       @NotNull
//       Long valorRestante,
//       @NotNull
//       int qtdParcelas,
       @NotNull
       String descricao

) {
}
