package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.HttpMessageDTO;
import com.openclassrooms.mddapi.dto.ThemeDTO;
import com.openclassrooms.mddapi.exceptions.UserAlreadySubscribedException;
import com.openclassrooms.mddapi.services.ThemeService;
import com.openclassrooms.mddapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PatchMapping("/{id}/subscribe/{user}")
    public HttpMessageDTO subscribeTheme(@PathVariable Long id, @PathVariable Long user) throws UserAlreadySubscribedException {
        themeService.subscribe(id, user);
        return new HttpMessageDTO("Subscribe successfully");
    }

    @PatchMapping("/{id}/unsubscribe/{user}")
    public HttpMessageDTO unsubscribeTheme(@PathVariable Long id, @PathVariable Long user) {
        themeService.unsubscribe(id, user);
        return new HttpMessageDTO("Unsubscribe successfully");
    }
}
