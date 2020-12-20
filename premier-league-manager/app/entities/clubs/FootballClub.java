package entities.clubs;

import java.io.Serializable;


public class FootballClub extends SportClub implements Serializable, Comparable<FootballClub> {
    private int numOfWin;
    private int numOfDefeat;
    private int numOfDraw;
    private int numOfPlayedMatch;
    private int point;
    private int scoredGoal;
    private int receivedGoal;
//    private List<Match> matchList = new ArrayList<>();


    public FootballClub(String clubName, String clubLocation) {
        super(clubName, clubLocation);
    }

    public int getNumOfWin() {
        return this.numOfWin;
    }

    public void setNumOfWin() {
        this.numOfWin++;
    }

    public int getNumOfDefeat() {
        return this.numOfDefeat;
    }

    public void setNumOfDefeat() {
        this.numOfDefeat++;
    }

    public int getNumOfDraw() {
        return this.numOfDraw;
    }

    public void setNumOfDraw() {
        this.numOfDraw++;
    }

    public int getNumOfPlayedMatch() {
        return this.numOfPlayedMatch;
    }

    public void setNumOfPlayedMatch() {
        this.numOfPlayedMatch++;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point += point;
    }

    public int getScoredGoal() {
        return this.scoredGoal;
    }

    public void setScoredGoal(int scoredGoal) {
        this.scoredGoal += scoredGoal;
    }

    public int getReceivedGoal() {
        return this.receivedGoal;
    }

    public void setReceivedGoal(int receivedGoal) {
        this.receivedGoal += receivedGoal;
    }

//    public List<Match> getMatchList() {
//        return this.matchList;
//    }
//
//    public void setMatchList(Match match) {
//        this.matchList.add(match);
//    }

    @Override
    public int compareTo(FootballClub footBallClub) {
        if (this.point == footBallClub.getPoint()) {
            return this.scoredGoal - footBallClub.getScoredGoal() >= 0 ? -1 : 1;
        } else {
            return this.point - footBallClub.getPoint() > 0 ? -1 : 1;
        }
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "numOfWin=" + numOfWin +
                ", numOfDefeat=" + numOfDefeat +
                ", numOfDraw=" + numOfDraw +
                ", numOfPlayedMatch=" + numOfPlayedMatch +
                ", point=" + point +
                ", scoredGoal=" + scoredGoal +
                ", receivedGoal=" + receivedGoal +
                '}';
    }
}
