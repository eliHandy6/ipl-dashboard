package com.ciffertech.ipldashboard.controller;

import com.ciffertech.ipldashboard.model.Match;
import com.ciffertech.ipldashboard.model.Team;
import com.ciffertech.ipldashboard.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/teams")

public class TeamController {

    private final TeamService teamService;

    @GetMapping("/{teamName}")
    public ResponseEntity<Team> getTeamByName(@PathVariable String teamName) {
        try {
            Team team = teamService.findTeamByTeamName(teamName);
            return ResponseEntity.ok(team);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{teamName}/matches")
    public ResponseEntity<List<Match>> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        try {
            List<Match> matchList = teamService.findTeamMatchesInAyear(teamName, startDate, endDate);
            return ResponseEntity.ok(matchList);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping()
    public ResponseEntity<List<Team>> getAllTeams() {
        try {
            List<Team> teams = teamService.getAllTeams();
            return ResponseEntity.ok(teams);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
