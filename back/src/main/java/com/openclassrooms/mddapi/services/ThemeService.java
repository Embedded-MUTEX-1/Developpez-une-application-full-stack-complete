package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.ThemeDTO;

import java.util.List;

public interface ThemeService {
    public void subscribe(Long themeId, Long userId);
    public void unsubscribe(Long themeId, Long userId);
    public List<ThemeDTO> getThemes();
}
