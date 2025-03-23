package com.example.SportProgam.event_package.repository;

import com.example.SportProgam.event_package.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<TeamModel, Long> {
    @Query(nativeQuery = true, value = "select * from public.teams where user_id = :userId")
    List<TeamModel> findAllTeamsByUserId(Long userId);
    @Query(nativeQuery = true, value = "select * from public.teams where event_id = :eventId")
    List<TeamModel> findAllByEvent(Long eventId);
}
