package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.RegisterDTO;
import com.openclassrooms.mddapi.dto.UserDTO;
import com.openclassrooms.mddapi.exceptions.EntityAlreadyExistsException;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void registerUser(RegisterDTO registerDTO) throws EntityAlreadyExistsException {
        if (userRepository.existsByEmail(registerDTO.getEmail()))
            throw new EntityAlreadyExistsException();

        userRepository.save(modelMapper.map(registerDTO, User.class));
    }

    public UserDTO getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow();
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void updateUser(Long userId, RegisterDTO registerDTO) {
        User user = userRepository.findById(userId).orElseThrow();

        user.setEmail(registerDTO.getEmail());
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());

        userRepository.save(user);
    }
}
