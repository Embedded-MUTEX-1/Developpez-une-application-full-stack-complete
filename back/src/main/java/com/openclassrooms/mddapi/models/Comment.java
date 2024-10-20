package com.openclassrooms.mddapi.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    private Long id;

    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Article article;
}
