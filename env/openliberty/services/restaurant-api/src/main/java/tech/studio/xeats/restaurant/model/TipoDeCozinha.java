package tech.studio.xeats.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.StringJoiner;

@Entity
@Table(name = "tipo_de_cozinha")
public class TipoDeCozinha {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min=3, max=100)
  private String nome;

  public TipoDeCozinha() {
  }

  public TipoDeCozinha(String nome) {
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", TipoDeCozinha.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("nome='" + nome + "'")
        .toString();
  }
}
