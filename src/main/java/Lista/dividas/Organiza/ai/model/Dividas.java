package Lista.dividas.Organiza.ai.model;

import Lista.dividas.Organiza.ai.dto.DadosCadastroDividasDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "dividas")
@Entity(name = "Dividas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dividas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total")
    private int valorTotal;
    private int valorPago;
    private int valorRestante;
//    private int qtdParcelas;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private SituacaoDividas situacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;



    private boolean ativo;

    public Dividas (DadosCadastroDividasDto dados){
        this.ativo = true;
        this.usuario = dados.idUsuario();
        this.valorPago = dados.valorPago();
//        this.qtdParcelas = dados.qtdParcelas();
        this.valorTotal = dados.valorTotal();
        this.descricao = dados.descricao();
    }

    public void excluir(){
        this.ativo = false;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public SituacaoDividas getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoDividas situacao) {
        this.situacao = situacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getValorPago() {
        return valorPago;
    }

    public void setValorPago(int valorPago) {
        this.valorPago = valorPago;
    }

    public int getValorRestante() {
        return valorRestante;
    }

    public void setValorRestante(int valorRestante) {
        this.valorRestante = valorRestante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
