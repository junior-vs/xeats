package tech.studio.xeats.restaurant.shared.security.model;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @JsonbTransient
  private String name;

  @NotBlank
  @JsonbTransient
  private String password;

  @ManyToMany(fetch = FetchType.EAGER) @JsonbTransient
  @JoinTable(
      name = "user_authorities",
      joinColumns = { @JoinColumn(name = "user_id") },
      inverseJoinColumns = { @JoinColumn(name = "authorities_authority") }
  )
  private List<Role> authorities = new ArrayList<>();

  @Deprecated
  public User() {
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }


  public Collection<?> getAuthorities() {
    return authorities;
  }

  public List<String> getRoles() {
    return authorities.stream().map(Role::getRole).collect(Collectors.toList());
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("name='" + name + "'")
        .add("password='" + password + "'")
        .add("authorities=" + authorities)
        .toString();
  }
}
