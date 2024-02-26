package br.com.sergiowink.ranking_api.modules.admin.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sergiowink.ranking_api.modules.admin.models.Admin;
import br.com.sergiowink.ranking_api.modules.admin.models.Event;
import br.com.sergiowink.ranking_api.modules.admin.models.Team;
import br.com.sergiowink.ranking_api.modules.admin.services.AddPointsToTeamService;
import br.com.sergiowink.ranking_api.modules.admin.services.CreateAdminService;
import br.com.sergiowink.ranking_api.modules.admin.services.CreateEventService;
import br.com.sergiowink.ranking_api.modules.admin.services.CreateTeamService;
import br.com.sergiowink.ranking_api.modules.admin.services.DeleteTeamService;
import br.com.sergiowink.ranking_api.modules.admin.services.EventListService;
import br.com.sergiowink.ranking_api.modules.admin.services.TeamRankingListService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    
    @Autowired
    private CreateAdminService createAdminService;

    @Autowired
    private CreateTeamService createTeamService;

    @Autowired
    private DeleteTeamService deleteTeamService;

    @Autowired
    private TeamRankingListService teamRankingListService;

    @Autowired
    private AddPointsToTeamService addPointsToTeamService;

    @Autowired
    private CreateEventService createEventService;

    @Autowired 
    private EventListService eventList;

    @PostMapping(value = "/")
    public ResponseEntity<Object> createAdmin(@RequestBody Admin admin){
        var result = this.createAdminService.execute(admin);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/team")
    public ResponseEntity<Object> createTeam(@RequestBody Team team){
        try {
            var result = this.createTeamService.execute(team);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/team/{id}")
    public ResponseEntity<Object> deleteTeam(@PathVariable UUID id){
        try {
            this.deleteTeamService.execute(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/team")
    public ResponseEntity<Object> teamRankingList(){
        var result = this.teamRankingListService.execute();

        return ResponseEntity.ok().body(result);
    }

    @PutMapping(value = "/team/{id}/{points}")
    public ResponseEntity<Object> addPointsToTeam(@PathVariable UUID id, @PathVariable int points){
            try {
                var result = this.addPointsToTeamService.execute(id, points);
                return ResponseEntity.ok().body(result);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }


    @PostMapping(value = "/event")
    public ResponseEntity<Object> createEvent(@RequestBody Event event){
        try {
            var result = this.createEventService.execute(event);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/event")
    public ResponseEntity<Object> eventList(){
        var result = this.eventList.execute();

        return ResponseEntity.ok().body(result);
    }

}
