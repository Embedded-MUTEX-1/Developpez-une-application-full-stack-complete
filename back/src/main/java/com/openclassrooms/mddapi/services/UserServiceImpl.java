package com.openclassrooms.mddapi.services;

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

    public void registerUser(UserDTO userDTO) throws EntityAlreadyExistsException {
        if (userRepository.existsByEmail(userDTO.getEmail()))
            throw new EntityAlreadyExistsException();

        userRepository.save(modelMapper.map(userDTO, User.class));
    }

    public UserDTO getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow();
        return modelMapper.map(user, UserDTO.class);
    }

    public void updateUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).orElseThrow();

        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        userRepository.save(user);
    }
}
