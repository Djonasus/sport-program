package com.example.SportProgam.event_package.repository;

import com.example.SportProgam.event_package.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamModel, Long> {
}
