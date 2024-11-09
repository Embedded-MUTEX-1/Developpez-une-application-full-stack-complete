package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.RegisterDTO;
import com.openclassrooms.mddapi.dto.UpdateUserDTO;
import com.openclassrooms.mddapi.dto.UserDTO;
import com.openclassrooms.mddapi.exceptions.EntityAlreadyExistsException;
import com.openclassrooms.mddapi.models.User;

public interface UserService {
    public void registerUser(RegisterDTO registerDTO) throws EntityAlreadyExistsException;

    public UserDTO getUserById(long id);

    public void updateUser(UpdateUserDTO update);

    public User findByEmail(String email);
}
