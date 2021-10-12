package com.ciffertech.ipldashboard.service;

import com.ciffertech.ipldashboard.model.Match;
import com.ciffertech.ipldashboard.model.Team;

import java.time.LocalDate;
import java.util.List;

public interface TeamService {

    Team findTeamByTeamName(String teamName);
    List<Match> findTeamMatchesInAyear(String teamName, LocalDate startDate, LocalDate stopDate);

    List<Team> getAllTeams();
}
