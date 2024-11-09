package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.AuthDTO;
import com.openclassrooms.mddapi.dto.AuthResponseDTO;

public interface LoginService {
    public AuthResponseDTO login(AuthDTO authDTO);
}
