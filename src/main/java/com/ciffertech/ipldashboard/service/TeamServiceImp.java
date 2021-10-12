package com.ciffertech.ipldashboard.service;

import com.ciffertech.ipldashboard.model.Match;
import com.ciffertech.ipldashboard.model.Team;
import com.ciffertech.ipldashboard.repository.MatchRepository;
import com.ciffertech.ipldashboard.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TeamServiceImp implements TeamService {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    @Override
    public Team findTeamByTeamName(String teamName) {
        Team team = teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.findMatchesByTeam(teamName, 4));
        return team;
    }

    @Override
    public List<Match> findTeamMatchesInAyear(String teamName, LocalDate startDate, LocalDate stopDate) {
        return matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, stopDate);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
