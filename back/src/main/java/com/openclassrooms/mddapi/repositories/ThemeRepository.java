package com.openclassrooms.mddapi.repositories;

import com.openclassrooms.mddapi.models.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long> {
}
