package Lista.dividas.Organiza.ai.model;

import Lista.dividas.Organiza.ai.dto.DadosCadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    private boolean ativo;
    @OneToMany(mappedBy = "usuario")
    private List<Dividas> dividas;


    public Usuario (DadosCadastroUsuarioDto dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.cpf = dados.cpf();
        this.email = dados.email();
    }

    public List<Dividas> getDividas() {
        return dividas;
    }

    public void setDividas(List<Dividas> dividas) {
        this.dividas = dividas;
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public void excluir(){
        this.ativo = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

