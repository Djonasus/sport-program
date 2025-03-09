package com.example.SportProgam.event_package.repository;

import com.example.SportProgam.event_package.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventModel, Long> {

}
