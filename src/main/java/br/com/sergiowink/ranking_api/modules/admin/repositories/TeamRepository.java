package br.com.sergiowink.ranking_api.modules.admin.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sergiowink.ranking_api.modules.admin.models.Team;



public interface TeamRepository extends JpaRepository<Team, UUID>{
    Optional<Team> findByUsername(String username);
    List<Team> findAllByOrderByPointsDesc();
}
