package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    NOTADMIN("ROLE_NOTADMIN"),
    ADMIN("ROLE_ADMIN");

    private String value;
}
