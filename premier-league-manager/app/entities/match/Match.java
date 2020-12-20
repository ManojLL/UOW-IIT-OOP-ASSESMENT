package entities.match;

import entities.clubs.FootballClub;
import entities.date.Date;

import java.io.Serializable;
import java.util.Objects;

public class Match implements Serializable {
    private FootballClub teamA;
    private FootballClub teamB;
    private Date date;
    private int teamAScore;
    private int teamBScore;
    private String status;

    public Match(FootballClub teamA, FootballClub teamB, Date date, int teamAScore, int teamBScore, String status) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
        this.status = status;
    }

    public FootballClub getTeamA() {
        return this.teamA;
    }

    public void setTeamA(FootballClub teamA) {
        this.teamA = teamA;
    }

    public FootballClub getTeamB() {
        return this.teamB;
    }

    public void setTeamB(FootballClub teamB) {
        this.teamB = teamB;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTeamAScore() {
        return this.teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore() {
        return this.teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;
        Match match = (Match) o;
        return getTeamAScore() == match.getTeamAScore() &&
                getTeamBScore() == match.getTeamBScore() &&
                getTeamA().equals(match.getTeamA()) &&
                getTeamB().equals(match.getTeamB()) &&
                getDate().equals(match.getDate()) &&
                getStatus().equals(match.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeamA(), getTeamB(), getDate(), getTeamAScore(), getTeamBScore(), getStatus());
    }

    @Override
    public String toString() {
        return "Match{" +
                "teamA=" + teamA +
                ", teamB=" + teamB +
                ", date=" + date +
                ", teamAScore=" + teamAScore +
                ", teamBScore=" + teamBScore +
                ", status='" + status + '\'' +
                '}';
    }
}
