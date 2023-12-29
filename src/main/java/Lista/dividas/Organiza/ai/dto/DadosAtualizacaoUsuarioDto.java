package Lista.dividas.Organiza.ai.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuarioDto(
        @NotNull
        Long idUsuario,
        String nome,
        String email

) {
}
