package com.acko.pager.service;

import com.acko.pager.entities.Developer;
import com.acko.pager.entities.Team;
import com.acko.pager.pojos.TeamPojo;
import com.acko.pager.repository.DeveloperRepository;
import com.acko.pager.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TeamServiceImpl  implements TeamService{
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    DeveloperRepository developerRepository;


    @Override
    @Transactional
    public TeamPojo saveTeamAndDevelopers(TeamPojo teamPojo) {
        Team team = teamPojo.getTeam();
        List<Developer> developerList = teamPojo.getDeveloperList();
        team = teamRepository.save(team);
        teamPojo.setTeam(team);
        List<Developer> developers = new ArrayList<>();
        for(int i=0;i<developerList.size();i++){
            Developer developer = developerList.get(i);
            developer.setTeam(team);
            developers.add(developerRepository.save(developer));
        }
        teamPojo.setDeveloperList(developers);
        return teamPojo;
    }

    @Override
    public Developer selectDeveloper(Integer teamId) {
        Optional<List<Developer>> developerList = developerRepository.getDevelopersByTeamId(teamId);
        if(!developerList.isEmpty()){
            int size = developerList.get().size();
            int index = (int) Math.floor(size  *Math.random());
            log.info("Seding Alert to notification service for developer {}", developerList.get().get(index));
            return developerList.get().get(index);
        }
        Optional<Developer> developer = Optional.ofNullable(null);

        return developer.get();
    }
}
