package br.com.sergiowink.ranking_api.modules.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.ranking_api.modules.admin.models.Team;
import br.com.sergiowink.ranking_api.modules.admin.repositories.TeamRepository;
import br.com.sergiowink.ranking_api.modules.exceptions.TeamFoundException;

@Service
public class CreateTeamService {
    
    @Autowired 
    private TeamRepository teamRepository;

    public Team execute(Team team){
        this.teamRepository.findByUsername(team.getUsername())
        .ifPresent((t) -> {throw new TeamFoundException();
        });

        return this.teamRepository.save(team);
    }
}
