package br.com.sergiowink.ranking_api.modules.admin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.ranking_api.modules.admin.models.Event;
import br.com.sergiowink.ranking_api.modules.admin.repositories.EventRepository;
import br.com.sergiowink.ranking_api.modules.exceptions.EventFoundException;

@Service
public class CreateEventService {
    
    @Autowired
    private EventRepository eventRepository;

    public Event execute(Event event) {
       Optional<Event> existingEvent = 
        this.eventRepository.findByDateOfEventOrHourOfEvent(event.getDateOfEvent(), event.getHourOfEvent());

       if(existingEvent.isPresent()){
        throw new EventFoundException();
       }

       return this.eventRepository.save(event);
    }
}
