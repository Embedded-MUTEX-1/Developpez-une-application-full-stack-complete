package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.RegisterDTO;
import com.openclassrooms.mddapi.dto.UpdateUserDTO;
import com.openclassrooms.mddapi.dto.UserDTO;
import com.openclassrooms.mddapi.exceptions.EntityAlreadyExistsException;
import com.openclassrooms.mddapi.exceptions.UserAlreadySubscribedException;
import com.openclassrooms.mddapi.models.User;

/**
 * Interface de gestion des utilisateurs
 */
public interface UserService {
    /**
     * <p>Permet d'enregistrer un nouvel utilisateur</p>
     * @param registerDTO données d'enregistrement du nouvel utilisateur
     * @throws EntityAlreadyExistsException si l'utilisateur est déjà existant
     */
    public void registerUser(RegisterDTO registerDTO) throws EntityAlreadyExistsException;
    /**
     * <p>Permet d'obtenir un utilisateur par son id</p>
     * @param id Id de l'utilisateur
     * @return Un utilisateur
     */
    public UserDTO getUserById(long id);
    /**
     * <p>Permet modifier un utilisateur</p>
     * @param update données de modification de l'utilisateur
     */
    public void updateUser(UpdateUserDTO update);
    /**
     * <p>Permet d'obtenir un utilisateur par son email</p>
     * @param email mail de l'utilisateur
     * @return Un utilisateur
     */
    public User findByEmail(String email);
}
