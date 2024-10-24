package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.HttpMessageDTO;
import com.openclassrooms.mddapi.dto.ThemeDTO;
import com.openclassrooms.mddapi.services.ThemeService;
import com.openclassrooms.mddapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/themes")
public class ThemeController {

    private final ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("")
    public List<ThemeDTO> getThemes() {
        return themeService.getThemes();
    }

    @PatchMapping("/api/theme/{id}/subscribe/{userId}")
    public HttpMessageDTO subscribeTheme(@PathVariable Long id, @PathVariable Long userId) {
        themeService.subscribe(id, userId);
        return new HttpMessageDTO("Subscribe successfully");
    }

    @PatchMapping("/api/theme/{id}/subscribe/{userId}")
    public HttpMessageDTO unsubscribeTheme(@PathVariable Long id, @PathVariable Long userId) {
        themeService.unsubscribe(id, userId);
        return new HttpMessageDTO("Unsubscribe successfully");
    }
}
