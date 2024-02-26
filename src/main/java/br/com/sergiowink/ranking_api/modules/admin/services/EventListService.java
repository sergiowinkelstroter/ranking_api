package br.com.sergiowink.ranking_api.modules.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.ranking_api.modules.admin.models.Event;
import br.com.sergiowink.ranking_api.modules.admin.repositories.EventRepository;

@Service
public class EventListService {
    

    @Autowired
    private EventRepository eventRepository;


    public List<Event> execute(){
        return this.eventRepository.findAll();
    }
}
