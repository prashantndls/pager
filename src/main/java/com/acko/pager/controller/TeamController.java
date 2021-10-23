package com.acko.pager.controller;

import com.acko.pager.pojos.TeamPojo;
import com.acko.pager.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/teamCreator")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping()
    public @ResponseBody TeamPojo createTeam(@RequestBody TeamPojo teamPojo){
        log.info("Received request to create team {}", teamPojo.getTeam().getName());
        return  teamService.saveTeamAndDevelopers(teamPojo);
    }


}
