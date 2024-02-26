package br.com.sergiowink.ranking_api.modules.admin.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.ranking_api.modules.admin.repositories.TeamRepository;
import br.com.sergiowink.ranking_api.modules.exceptions.TeamNotFoundException;

@Service
public class DeleteTeamService {
    
    @Autowired
    private TeamRepository teamRepository;

    public void execute(UUID id){
        this.teamRepository.findById(id)
        .ifPresentOrElse((t) -> { this.teamRepository.deleteById(id);}, 
        () -> {throw new TeamNotFoundException();});
    }
}
