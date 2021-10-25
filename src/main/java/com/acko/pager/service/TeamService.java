package com.acko.pager.service;

import com.acko.pager.entities.Developer;
import com.acko.pager.pojos.TeamPojo;

public interface TeamService {
    public TeamPojo saveTeamAndDevelopers(TeamPojo teamPojo);
    public Developer selectDeveloper(Integer teamId);
}
