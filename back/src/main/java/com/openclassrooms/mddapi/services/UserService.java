package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.UserDTO;
import com.openclassrooms.mddapi.exceptions.EntityAlreadyExistsException;

public interface UserService {
    public void registerUser(UserDTO userDTO) throws EntityAlreadyExistsException;

    public UserDTO getUserById(long id);

    public void updateUser(UserDTO userDTO);
}
