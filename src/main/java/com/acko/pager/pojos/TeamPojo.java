package com.acko.pager.pojos;

import com.acko.pager.entities.Developer;
import com.acko.pager.entities.Team;

import java.util.List;

public class TeamPojo {
    private Team team;
    private List<Developer> developerList;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Developer> getDeveloperList() {
        return developerList;
    }

    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
    }
}
