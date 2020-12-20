package entities.clubs;

import java.io.Serializable;

public class SchoolSportClub extends FootballClub implements Serializable {
    public SchoolSportClub(String clubName, String clubLocation) {
        super(clubName, clubLocation);
    }
}
