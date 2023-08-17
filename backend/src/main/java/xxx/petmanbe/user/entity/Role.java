package xxx.petmanbe.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    ADMIN("ADMIN"),
    SHOP("SHOP"),
    USER("USER");

    private final String value;

}
