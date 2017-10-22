package com.aytengoksenin.barutcu.positivedigitalassesment.Model;

import java.util.List;

/**
 * This model corresponds to detail of a specific league
 * Created by goksenin.barutcu on 21/10/2017.
 */

public class LeagueStageDetail {

    private int id;
    private String name;
    private String TournamentName;
    private int shownOrder;
    private String tournamentFK;
    private String gender;
    private String countryFK;
    private String countryName;
    private String startDate;
    private String endDate;
    private int n;
    private Boolean IsActive;
    private String CurrentWeek;
    private int TotalWeek;
    private int MatchCount;
    private String ut;
    private String logo;
    private String[] LeagueFixture;
    private List<LeagueTableDetail> LeagueTable;

    public LeagueStageDetail(int id, String name, String tournamentNameSüper, int shownOrder, String tournament, String gender, String country, String countryName, String startDate, String endDate, int n, Boolean isActive, String current, int totalWeek, int matchCount, String ut, String logo, String[] leagueFixture, List<LeagueTableDetail> leagueTable) {
        this.id = id;
        this.name = name;
        this.TournamentName = tournamentNameSüper;
        this.shownOrder = shownOrder;
        this.tournamentFK = tournament;
        this.gender = gender;
        this.countryFK = country;
        this.countryName = countryName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.n = n;
        IsActive = isActive;
        CurrentWeek = current;
        TotalWeek = totalWeek;
        MatchCount = matchCount;
        this.ut = ut;
        this.logo = logo;
        LeagueFixture = leagueFixture;
        LeagueTable = leagueTable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTournamentNameSüper() {
        return TournamentName;
    }

    public int getShownOrder() {
        return shownOrder;
    }

    public String getTournament() {
        return tournamentFK;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return countryFK;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getN() {
        return n;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public String getCurrent() {
        return CurrentWeek;
    }

    public int getTotalWeek() {
        return TotalWeek;
    }

    public int getMatchCount() {
        return MatchCount;
    }

    public String getUt() {
        return ut;
    }

    public String getLogo() {
        return logo;
    }

    public String[] getLeagueFixture() {
        return LeagueFixture;
    }

    public List<LeagueTableDetail> getLeagueTable() {
        return LeagueTable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTournamentNameSüper(String tournamentNameSüper) {
        TournamentName = tournamentNameSüper;
    }

    public void setShownOrder(int shownOrder) {
        this.shownOrder = shownOrder;
    }

    public void setTournament(String tournament) {
        this.tournamentFK = tournament;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.countryFK = country;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public void setCurrent(String current) {
        CurrentWeek = current;
    }

    public void setTotalWeek(int totalWeek) {
        TotalWeek = totalWeek;
    }

    public void setMatchCount(int matchCount) {
        MatchCount = matchCount;
    }

    public void setUt(String ut) {
        this.ut = ut;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setLeagueFixture(String[] leagueFixture) {
        LeagueFixture = leagueFixture;
    }

    public void setLeagueTable(List<LeagueTableDetail> leagueTable) {
        LeagueTable = leagueTable;
    }
}
