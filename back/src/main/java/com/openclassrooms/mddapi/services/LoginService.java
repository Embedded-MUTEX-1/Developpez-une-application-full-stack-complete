package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.AuthDTO;
import com.openclassrooms.mddapi.dto.AuthResponseDTO;

/**
 * Interface de gestion de l'authentification
 */
public interface LoginService {
    /**
     * <p>Permet d'authentifier un utilisateur</p>
     * @param authDTO Objet contenant les données authentification
     * @return L'id de l'utilisateur et le token
     */
    public AuthResponseDTO login(AuthDTO authDTO);
}
