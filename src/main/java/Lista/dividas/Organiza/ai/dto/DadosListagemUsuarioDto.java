package Lista.dividas.Organiza.ai.dto;

import Lista.dividas.Organiza.ai.model.Dividas;
import Lista.dividas.Organiza.ai.model.Usuario;


import java.util.List;
import java.util.stream.Collectors;

public record DadosListagemUsuarioDto(
        Long id,
        String nome,
        String email,
        List<DadosListagemDividaDto> dividas
) {

    public DadosListagemUsuarioDto (Usuario usuario){
        this(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
               convertDividas(usuario.getDividas()));
    }

    private static List<DadosListagemDividaDto> convertDividas(List<Dividas> dividas) {
        return dividas.stream()
                .map(DadosListagemDividaDto::new)
                .collect(Collectors.toList());
    }
}
