package Lista.dividas.Organiza.ai.model;

import Lista.dividas.Organiza.ai.dto.DadosCadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String cpf;
    private String email;

    public Usuario (DadosCadastroUsuarioDto dados){
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.cpf = dados.cpf();
        this.email = dados.email();
    }

}
