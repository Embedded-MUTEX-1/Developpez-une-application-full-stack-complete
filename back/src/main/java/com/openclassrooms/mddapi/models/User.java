package com.openclassrooms.mddapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @lombok.NonNull
    private String email;

    @lombok.NonNull
    private String username;

    @lombok.NonNull
    private String password;

    @OneToMany
    private List<Article> articles;

    @OneToMany
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Theme> themes;
}
