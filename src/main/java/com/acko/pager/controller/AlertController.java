package com.acko.pager.controller;

import com.acko.pager.entities.Developer;
import com.acko.pager.repository.DeveloperRepository;
import com.acko.pager.repository.TeamRepository;
import com.acko.pager.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/alerter")
public class AlertController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/{teamId}")
    public @ResponseBody Developer createTeam(@PathVariable Integer teamId){
        return teamService.selectDeveloper(teamId);
    }
}
