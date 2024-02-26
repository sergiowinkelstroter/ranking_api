package br.com.sergiowink.ranking_api.modules.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.ranking_api.modules.admin.models.Team;
import br.com.sergiowink.ranking_api.modules.admin.repositories.TeamRepository;

@Service
public class TeamRankingListService {
    
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> execute(){
        return this.teamRepository.findAllByOrderByPointsDesc();
    }
}
