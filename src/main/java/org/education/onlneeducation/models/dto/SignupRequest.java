package org.education.onlneeducation.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignupRequest {
    String username;
    String password;
    Set<String> roles;
}
