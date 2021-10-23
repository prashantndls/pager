package com.acko.pager.controller;

import com.acko.pager.entities.Developer;
import com.acko.pager.repository.DeveloperRepository;
import com.acko.pager.repository.TeamRepository;
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
    private DeveloperRepository developerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping()
    public @ResponseBody String getTeam(){
        return "Hello";
    }
    @PostMapping()
    public @ResponseBody Developer createTeam(@RequestBody Integer teamId){
        Optional<List<Developer>> developerList = developerRepository.getDevelopersByTeamId(teamId);
        if(!developerList.isEmpty()){
            int size = developerList.get().size();
            int index = (int) ((size - 1)  *(Math.random()*100));
            log.info("Seding Alert to notification service for developer {}", developerList.get().get(index));
            return developerList.get().get(index);
        }
        Optional<Developer> developer = Optional.ofNullable(null);

        return developer.get();
    }
}
