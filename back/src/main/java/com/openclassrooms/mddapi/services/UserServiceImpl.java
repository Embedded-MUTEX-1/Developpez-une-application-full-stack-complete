package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.RegisterDTO;
import com.openclassrooms.mddapi.dto.UpdateUserDTO;
import com.openclassrooms.mddapi.dto.UserDTO;
import com.openclassrooms.mddapi.exceptions.EntityAlreadyExistsException;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
        TypeMap<User, UserDTO> typeMap = this.modelMapper.createTypeMap(User.class, UserDTO.class);
        typeMap.addMappings(mapper -> mapper.map(User::getThemes, UserDTO::setThemes));
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
    public void updateUser(UpdateUserDTO update) {
        User user = userRepository.findById(update.getId()).orElseThrow();

        user.setEmail(update.getEmail());
        user.setUsername(update.getUsername());
        user.setPassword(update.getPassword());

        userRepository.save(user);
    }
}
