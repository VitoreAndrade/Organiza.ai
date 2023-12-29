package Lista.dividas.Organiza.ai.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuarioDto(
        @NotBlank
        String nome,
        @NotNull
        int idade,
        @NotBlank
        String cpf,
        @NotBlank
        @Email
        String email
) {
}
