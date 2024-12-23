package com.example.SportProgam.repository;

import com.example.SportProgam.model.NewsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface NewsRepository extends JpaRepository<NewsModel, Long> {
    @Query(value = "SELECT * FROM news ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<NewsModel> findAllWithLimitAndNoSorted(@Param("limit") Long limit);

    @Query(value = "SELECT * FROM news ORDER BY id LIMIT :limit", nativeQuery = true)
    List<NewsModel> findAllWithLimitAndSorted(@Param("limit") Long limit);

    @Query(value = "SELECT * FROM news ORDER BY RANDOM()", nativeQuery = true)
    List<NewsModel> findAllWithoutLimitAndNoSorted();
}
