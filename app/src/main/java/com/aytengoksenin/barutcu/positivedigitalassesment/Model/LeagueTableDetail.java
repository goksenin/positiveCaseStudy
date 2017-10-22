package com.aytengoksenin.barutcu.positivedigitalassesment.Model;

import java.io.Serializable;

/**
 * This model corresponds to list of team with their details. Since We pass the model from
 * teamlistfragment to teamitemdetailfragment it implements serializable.
 * Created by goksenin.barutcu on 21/10/2017.
 */

public class LeagueTableDetail implements Serializable {
    
    private int id;
    private int TeamID;
    private String name;
    private int points;
    private int played;
    private int wins;
    private int draws;
    private int defeits;
    private int goalsfor;
    private int goalsagainst;
    private int average;
    private int rank;
    private String TeamLogo;
    private Boolean HasTeamLogo;

    public LeagueTableDetail(int id, int teamID, String name, int points, int played, int wins, int draws, int defeits, int goalsfor, int goalsagainst, int average, int rank1, String teamLogohttp, Boolean hasTeamLogo) {
        this.id = id;
        TeamID = teamID;
        this.name = name;
        this.points = points;
        this.played = played;
        this.wins = wins;
        this.draws = draws;
        this.defeits = defeits;
        this.goalsfor = goalsfor;
        this.goalsagainst = goalsagainst;
        this.average = average;
        this.rank = rank1;
        TeamLogo = teamLogohttp;
        HasTeamLogo = hasTeamLogo;
    }

    public int getId() {
        return id;
    }

    public int getTeamID() {
        return TeamID;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getPlayed() {
        return played;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeits() {
        return defeits;
    }

    public int getGoalsfor() {
        return goalsfor;
    }

    public int getGoalsagainst() {
        return goalsagainst;
    }

    public int getAverage() {
        return average;
    }

    public int getRank1() {
        return rank;
    }

    public String getTeamLogohttp() {
        return TeamLogo;
    }

    public Boolean getHasTeamLogo() {
        return HasTeamLogo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setDefeits(int defeits) {
        this.defeits = defeits;
    }

    public void setGoalsfor(int goalsfor) {
        this.goalsfor = goalsfor;
    }

    public void setGoalsagainst(int goalsagainst) {
        this.goalsagainst = goalsagainst;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public void setRank1(int rank1) {
        this.rank = rank1;
    }

    public void setTeamLogohttp(String teamLogohttp) {
        TeamLogo = teamLogohttp;
    }

    public void setHasTeamLogo(Boolean hasTeamLogo) {
        HasTeamLogo = hasTeamLogo;
    }
}
