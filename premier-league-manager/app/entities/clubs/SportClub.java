package entities.clubs;

import java.io.Serializable;
import java.util.Objects;

public abstract class SportClub implements Serializable {
    private String clubName;
    private String clubLocation;

    public SportClub(String clubName, String clubLocation) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }

    public String getClubName() {
        return this.clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLocation() {
        return this.clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportClub)) return false;
        SportClub sportClub = (SportClub) o;
        return this.clubName.equals(sportClub.getClubName());
    }

    @Override
    public String toString() {
        return "SportClub{" +
                "clubName='" + clubName + '\'' +
                ", clubLocation='" + clubLocation + '\'' +
                '}';
    }

}
