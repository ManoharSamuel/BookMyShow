package com.projects.bookmyshow.repositories;

import com.projects.bookmyshow.models.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {
    @Override
    Optional<MovieShow> findById(Long movieShowId);

    @Override
    MovieShow save(MovieShow movieShow);
}
