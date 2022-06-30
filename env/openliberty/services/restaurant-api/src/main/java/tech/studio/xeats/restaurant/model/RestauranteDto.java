package tech.studio.xeats.restaurant.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class RestauranteDto implements Serializable {

  private final Long id;
  private final String cnpj;
  private final String nome;
  private final String descricao;
  private final String cep;
  private final String endereco;
  private final BigDecimal taxaDeEntregaEmReais;
  private final Integer tempoDeEntregaMinimoEmMinutos;
  private final Integer tempoDeEntregaMaximoEmMinutos;
  private final Boolean aprovado;
  private final TipoDeCozinhaDto tipoDeCozinha;

  public RestauranteDto(Long id, String cnpj, String nome, String descricao, String cep,
      String endereco, BigDecimal taxaDeEntregaEmReais, Integer tempoDeEntregaMinimoEmMinutos,
      Integer tempoDeEntregaMaximoEmMinutos, Boolean aprovado, TipoDeCozinhaDto tipoDeCozinha) {
    this.id = id;
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

  public RestauranteDto(Restaurante restaurante) {
    this(restaurante.getId(),
        restaurante.getCnpj(),
        restaurante.getNome(),
        restaurante.getDescricao(),
        restaurante.getCep(),
        restaurante.getEndereco(),
        restaurante.getTaxaDeEntregaEmReais(),
        restaurante.getTempoDeEntregaMinimoEmMinutos(),
        restaurante.getTempoDeEntregaMaximoEmMinutos(),
        restaurante.getAprovado(),
        new TipoDeCozinhaDto(restaurante.getTipoDeCozinha())
        );
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

  public TipoDeCozinhaDto getTipoDeCozinha() {
    return tipoDeCozinha;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestauranteDto entity = (RestauranteDto) o;
    return Objects.equals(this.id, entity.id) &&
        Objects.equals(this.cnpj, entity.cnpj) &&
        Objects.equals(this.nome, entity.nome) &&
        Objects.equals(this.descricao, entity.descricao) &&
        Objects.equals(this.cep, entity.cep) &&
        Objects.equals(this.endereco, entity.endereco) &&
        Objects.equals(this.taxaDeEntregaEmReais, entity.taxaDeEntregaEmReais) &&
        Objects.equals(this.tempoDeEntregaMinimoEmMinutos, entity.tempoDeEntregaMinimoEmMinutos) &&
        Objects.equals(this.tempoDeEntregaMaximoEmMinutos, entity.tempoDeEntregaMaximoEmMinutos) &&
        Objects.equals(this.aprovado, entity.aprovado) &&
        Objects.equals(this.tipoDeCozinha, entity.tipoDeCozinha);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cnpj, nome, descricao, cep, endereco, taxaDeEntregaEmReais,
        tempoDeEntregaMinimoEmMinutos, tempoDeEntregaMaximoEmMinutos, aprovado, tipoDeCozinha);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "cnpj = " + cnpj + ", " +
        "nome = " + nome + ", " +
        "descricao = " + descricao + ", " +
        "cep = " + cep + ", " +
        "endereco = " + endereco + ", " +
        "taxaDeEntregaEmReais = " + taxaDeEntregaEmReais + ", " +
        "tempoDeEntregaMinimoEmMinutos = " + tempoDeEntregaMinimoEmMinutos + ", " +
        "tempoDeEntregaMaximoEmMinutos = " + tempoDeEntregaMaximoEmMinutos + ", " +
        "aprovado = " + aprovado + ", " +
        "tipoDeCozinha = " + tipoDeCozinha + ")";
  }
}
