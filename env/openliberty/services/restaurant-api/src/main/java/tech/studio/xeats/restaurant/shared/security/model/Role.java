package tech.studio.xeats.restaurant.shared.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name = "role")
public class Role {

  @Id
  private String authority;

  public Role() {
  }

  public String getAuthority() {
    return authority;
  }

  public String getRole() {
    return authority.replace("ROLE_", "");
  }

  public static enum ROLES {
    ADMIN, PARCEIRO;
    public String asAuthority() {
      return "ROLE_" + name();
    }
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Role.class.getSimpleName() + "[", "]")
        .add("authority='" + authority + "'")
        .toString();
  }
}
