package com.example.SportProgam.repository;

import com.example.SportProgam.model.NewsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsModel, Long> {
}
