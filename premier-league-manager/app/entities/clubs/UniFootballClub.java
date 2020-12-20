package entities.clubs;

import java.io.Serializable;

public class UniFootballClub extends FootballClub implements Serializable {
    public UniFootballClub(String clubName, String clubLocation) {
        super(clubName, clubLocation);
    }
}
