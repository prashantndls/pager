package com.acko.pager.repository;

import com.acko.pager.entities.Developer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {
    @Query(value="select * from developer d where d.team_id= :teamId", nativeQuery=true)
    public Optional<List<Developer>> getDevelopersByTeamId(Integer teamId);

}
