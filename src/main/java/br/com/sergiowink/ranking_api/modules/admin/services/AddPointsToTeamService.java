package br.com.sergiowink.ranking_api.modules.admin.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.ranking_api.modules.admin.models.Team;
import br.com.sergiowink.ranking_api.modules.admin.repositories.TeamRepository;
import br.com.sergiowink.ranking_api.modules.exceptions.TeamNotFoundException;

@Service
public class AddPointsToTeamService {
    
    @Autowired
    private TeamRepository teamRepository;

    public Team execute(UUID id, int points){
        Team updatedTeam = this.teamRepository.findById(id)
            .orElseThrow(TeamNotFoundException::new);
        
        updatedTeam.setPoints(points);
            
        return teamRepository.save(updatedTeam);
    }
}
