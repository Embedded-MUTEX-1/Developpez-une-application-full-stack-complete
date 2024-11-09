package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.AuthDTO;
import com.openclassrooms.mddapi.dto.AuthResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private JwtService jwtService;
    private AuthenticationProvider authenticationProvider;
    private UserService userService;

    @Autowired
    LoginServiceImpl(JwtService jwtService, AuthenticationProvider authenticationProvider, UserService userService) {
        this.jwtService = jwtService;
        this.authenticationProvider = authenticationProvider;
        this.userService = userService;
    }

    @Override
    public AuthResponseDTO login(AuthDTO authDTO) {
        authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(authDTO.getEmail(), authDTO.getPassword()));

        return new AuthResponseDTO(userService.findByEmail(authDTO.getEmail()).getId() , jwtService.generateToken(authDTO.getEmail()));
    }
}
