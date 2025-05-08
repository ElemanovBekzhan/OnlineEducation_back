package org.education.onlneeducation.models.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtResponse {

    String token;
    String type = "Baerer";
    UUID id;
    String username;
    List<String> roles;

    public JwtResponse(String token, UUID id, String username, List<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
        this.id = id;
    }


}
