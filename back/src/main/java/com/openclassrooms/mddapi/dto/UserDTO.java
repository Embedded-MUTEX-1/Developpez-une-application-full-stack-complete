package com.openclassrooms.mddapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDTO {
    private Long id;

    @lombok.NonNull
    private String email;

    @lombok.NonNull
    private String username;

    @lombok.NonNull
    private String password;
}
