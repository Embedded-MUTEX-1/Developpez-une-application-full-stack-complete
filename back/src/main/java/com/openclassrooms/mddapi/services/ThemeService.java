package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.ThemeDTO;
import com.openclassrooms.mddapi.exceptions.UserAlreadySubscribedException;

import java.util.List;

/**
 * Interface de gestion des themes
 */
public interface ThemeService {
    /**
     * <p>Permet d'abonner un utilisateur à un thème</p>
     * @param themeId Id du thème
     * @param userId Id de l'utilisateur
     * @throws UserAlreadySubscribedException si l'utilisateur est déjà abonné au thème
     */
    public void subscribe(Long themeId, Long userId) throws UserAlreadySubscribedException;
    /**
     * <p>Permet de désabonner un utilisateur à un thème</p>
     * @param themeId Id du thème
     * @param userId Id de l'utilisateur
     */
    public void unsubscribe(Long themeId, Long userId);
    /**
     * <p>Permet d'obtenir tous les thèmes</p>
     * @return Une liste de thème
     */
    public List<ThemeDTO> getThemes();
}
