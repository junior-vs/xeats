package tech.studio.xeats.restaurant.shared.security.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import tech.studio.xeats.restaurant.shared.security.model.Role;
import tech.studio.xeats.restaurant.shared.security.model.User;

public class UserDto implements Serializable {

  private final String name;
  private final List<String> authorities;

  public UserDto(String name, List<String> authorities) {
    this.name = name;
    this.authorities = authorities;
  }

  public UserDto(User user) {
    this.name =user.getName();
    this.authorities = user.getRoles();
  }


  public String getName() {
    return name;
  }

  public List<String> getAuthorities() {
    return authorities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDto entity = (UserDto) o;
    return Objects.equals(this.name, entity.name) &&
        Objects.equals(this.authorities, entity.authorities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, authorities);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "name = " + name + ", " +
        "authorities = " + authorities + ")";
  }
}
