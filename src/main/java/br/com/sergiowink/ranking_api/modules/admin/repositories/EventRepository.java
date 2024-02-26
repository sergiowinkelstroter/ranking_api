package br.com.sergiowink.ranking_api.modules.admin.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sergiowink.ranking_api.modules.admin.models.Event;

public interface EventRepository extends JpaRepository<Event, UUID>{
    Optional<Event> findByDateOfEventOrHourOfEvent(String dateOfEvent, String hourOfEvent);
} 
