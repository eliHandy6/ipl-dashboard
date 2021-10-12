package com.ciffertech.ipldashboard.repository;

import com.ciffertech.ipldashboard.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
    Team findByTeamName(String teamName);
}
