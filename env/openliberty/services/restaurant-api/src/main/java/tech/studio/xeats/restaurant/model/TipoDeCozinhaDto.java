package tech.studio.xeats.restaurant.model;

import java.io.Serializable;
import java.util.Objects;

public class TipoDeCozinhaDto implements Serializable {

  private final String nome;

  public TipoDeCozinhaDto(String nome) {
    this.nome = nome;
  }

  public TipoDeCozinhaDto(TipoDeCozinha tipoDeCozinha) {
    this(tipoDeCozinha.getNome());
  }

  public String getNome() {
    return nome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TipoDeCozinhaDto entity = (TipoDeCozinhaDto) o;
    return Objects.equals(this.nome, entity.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "nome = " + nome + ")";
  }
}
