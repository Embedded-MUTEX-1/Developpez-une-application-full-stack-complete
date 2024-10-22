package com.openclassrooms.mddapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theme {
    @Id
    private Long id;

    private String name;

    @ManyToMany
    private List<User> users;

    @OneToMany
    private List<Article> articles;
}
