package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.ThemeDTO;
import com.openclassrooms.mddapi.exceptions.UserAlreadySubscribedException;

import java.util.List;

public interface ThemeService {
    public void subscribe(Long themeId, Long userId) throws UserAlreadySubscribedException;
    public void unsubscribe(Long themeId, Long userId);
    public List<ThemeDTO> getThemes();
}
