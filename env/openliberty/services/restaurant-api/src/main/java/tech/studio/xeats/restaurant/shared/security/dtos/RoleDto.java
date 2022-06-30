package tech.studio.xeats.restaurant.shared.security.dtos;

import java.io.Serializable;
import java.util.Objects;

public class RoleDto implements Serializable {

  private final String authority;

  public RoleDto(String authority) {
    this.authority = authority;
  }

  public String getAuthority() {
    return authority;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleDto entity = (RoleDto) o;
    return Objects.equals(this.authority, entity.authority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authority);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "authority = " + authority + ")";
  }
}
