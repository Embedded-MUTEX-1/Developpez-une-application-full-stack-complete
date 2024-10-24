package com.openclassrooms.mddapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    private Long id;

    private String title;

    private String content;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Theme theme;

    @OneToMany
    private List<Comment> comments;
}
