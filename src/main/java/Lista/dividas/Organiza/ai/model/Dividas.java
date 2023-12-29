package Lista.dividas.Organiza.ai.model;

import Lista.dividas.Organiza.ai.dto.DadosCadastroDividasDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long valorTotal;
    private Long valorPago;
    private Long valorRestante;
    private int qtdParcelas;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private boolean ativo;

    public Dividas (DadosCadastroDividasDto dados){
        this.ativo = true;
        this.usuario = dados.idUsuario();
        this.valorPago = dados.valorPago();
        this.valorRestante = dados.valorRestante();
        this.qtdParcelas = dados.qtdParcelas();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getValorPago() {
        return valorPago;
    }

    public void setValorPago(Long valorPago) {
        this.valorPago = valorPago;
    }

    public Long getValorRestante() {
        return valorRestante;
    }

    public void setValorRestante(Long valorRestante) {
        this.valorRestante = valorRestante;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
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
