package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.PostCommentDTO;

/**
 * Interface de gestion des commentaires
 */
public interface CommentService {
    /**
     * <p>Permet de poster un commentaire </p>
     * @param commentDTO Objet contenant les données de du commentaire
     */
    public void addComment(PostCommentDTO commentDTO);
}
