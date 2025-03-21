package com.example.SportProgam.event_package.repository;

import com.example.SportProgam.event_package.model.EventRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRequestRepository extends JpaRepository<EventRequestModel, Long> {
}
