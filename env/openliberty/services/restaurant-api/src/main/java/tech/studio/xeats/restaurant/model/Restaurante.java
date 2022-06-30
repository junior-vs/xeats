package tech.studio.xeats.restaurant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.StringJoiner;
import tech.studio.xeats.restaurant.shared.security.model.User;

@Entity
@Table(name = "restaurante")
@NamedQueries({
    @NamedQuery(name = "Restaurante.findAll", query = "select r from Restaurante r"),
    @NamedQuery(name = "Restaurante.countBy", query = "select count(r) from Restaurante r"),
    @NamedQuery(name = "Restaurante.findByNome", query = "select r from Restaurante r where r.nome = :nome"),
    @NamedQuery(name = "Restaurante.deleteById", query = "delete from Restaurante r where r.id = :id"),
    @NamedQuery(name = "Restaurante.updateAprovadoById", query = "update Restaurante r set r.aprovado = TRUE where r.id = :id"),
    @NamedQuery(name = "Restaurante.findByAprovado", query = "select r from Restaurante r where r.aprovado = :aprovado"),
    @NamedQuery(name = "Restaurante.findByAprovadoAndTipoDeCozinha", query = "select r from Restaurante r where r.aprovado = :aprovado and r.tipoDeCozinha = :tipoDeCozinha"),
    @NamedQuery(name = "Restaurante.findByUser", query = "select r from Restaurante r where r.user = :user")
})

public class Restaurante {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max=18)
  private String cnpj;

  @NotBlank @Size(max=255)
  private String nome;

  @Size(max=1000)
  private String descricao;

  @NotBlank @Size(max=9)
  private String cep;

  @NotBlank @Size(max=300)
  private String endereco;

  @Positive
  @Column(name = "taxa_de_entrega_em_reais")
  private BigDecimal taxaDeEntregaEmReais;

  @Column(name ="tempo_de_entrega_minimo_em_minutos")
  @Positive @Min(10) @Max(180)
  private Integer tempoDeEntregaMinimoEmMinutos;

  @Column(name ="tempo_de_entrega_maximo_em_minutos")
  @Positive @Min(10) @Max(180)
  private Integer tempoDeEntregaMaximoEmMinutos;

  private Boolean aprovado;

  @ManyToOne(optional=false)
  @JoinColumn(name = "tipo_de_cozinha_id")
  private TipoDeCozinha tipoDeCozinha;

  @OneToOne
  private User user;

  public Restaurante() {
  }

  public Restaurante(String cnpj, String nome, String descricao, String cep, String endereco,
      BigDecimal taxaDeEntregaEmReais, Integer tempoDeEntregaMinimoEmMinutos,
      Integer tempoDeEntregaMaximoEmMinutos, Boolean aprovado, TipoDeCozinha tipoDeCozinha) {
    this.cnpj = cnpj;
    this.nome = nome;
    this.descricao = descricao;
    this.cep = cep;
    this.endereco = endereco;
    this.taxaDeEntregaEmReais = taxaDeEntregaEmReais;
    this.tempoDeEntregaMinimoEmMinutos = tempoDeEntregaMinimoEmMinutos;
    this.tempoDeEntregaMaximoEmMinutos = tempoDeEntregaMaximoEmMinutos;
    this.aprovado = aprovado;
    this.tipoDeCozinha = tipoDeCozinha;
  }

  public Long getId() {
    return id;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public String getCep() {
    return cep;
  }

  public String getEndereco() {
    return endereco;
  }

  public BigDecimal getTaxaDeEntregaEmReais() {
    return taxaDeEntregaEmReais;
  }

  public Integer getTempoDeEntregaMinimoEmMinutos() {
    return tempoDeEntregaMinimoEmMinutos;
  }

  public Integer getTempoDeEntregaMaximoEmMinutos() {
    return tempoDeEntregaMaximoEmMinutos;
  }

  public Boolean getAprovado() {
    return aprovado;
  }

  public TipoDeCozinha getTipoDeCozinha() {
    return tipoDeCozinha;
  }

  public User getUser() {
    return user;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Restaurante.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("cnpj='" + cnpj + "'")
        .add("nome='" + nome + "'")
        .add("descricao='" + descricao + "'")
        .add("cep='" + cep + "'")
        .add("endereco='" + endereco + "'")
        .add("taxaDeEntregaEmReais=" + taxaDeEntregaEmReais)
        .add("tempoDeEntregaMinimoEmMinutos=" + tempoDeEntregaMinimoEmMinutos)
        .add("tempoDeEntregaMaximoEmMinutos=" + tempoDeEntregaMaximoEmMinutos)
        .add("aprovado=" + aprovado)
        .add("tipoDeCozinha=" + tipoDeCozinha)
        .add("user=" + user)
        .toString();
  }
}
