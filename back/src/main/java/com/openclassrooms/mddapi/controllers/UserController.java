package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.HttpMessageDTO;
import com.openclassrooms.mddapi.dto.RegisterDTO;
import com.openclassrooms.mddapi.dto.UpdateUserDTO;
import com.openclassrooms.mddapi.dto.UserDTO;
import com.openclassrooms.mddapi.exceptions.EntityAlreadyExistsException;
import com.openclassrooms.mddapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public HttpMessageDTO registerUser(@RequestBody RegisterDTO register) throws EntityAlreadyExistsException {
        userService.registerUser(register);
        return new HttpMessageDTO("User registered successfully");
    }

    // TODO get user with security context '@GetMapping("/me")'
    @GetMapping("/{id}")
    public UserDTO getMe(@PathVariable Long id) throws EntityNotFoundException {
        return userService.getUserById(id);
    }

    // TODO get user with security context '@PutMapping("/me")'
    @PutMapping("/")
    public HttpMessageDTO updateUser(@RequestBody UpdateUserDTO update) {
        userService.updateUser(update);
        return new HttpMessageDTO("User updated successfully");
    }
}
