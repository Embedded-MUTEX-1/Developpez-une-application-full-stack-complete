package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.ThemeDTO;
import com.openclassrooms.mddapi.models.Theme;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {

    private ThemeRepository themeRepository;
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Autowired
    ThemeServiceImpl(ThemeRepository themeRepository, UserRepository userRepository) {
        this.themeRepository = themeRepository;
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void subscribe(Long themeId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Theme theme = themeRepository.findById(themeId).orElseThrow();

        user.getThemes().add(theme);

        userRepository.save(user);
    }

    @Override
    public void unsubscribe(Long themeId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Theme theme = themeRepository.findById(themeId).orElseThrow();

        user.getThemes().removeIf(item -> item.getId().equals(theme.getId()));

        userRepository.save(user);
    }

    @Override
    public List<ThemeDTO> getThemes() {
        return List.of();
    }
}
