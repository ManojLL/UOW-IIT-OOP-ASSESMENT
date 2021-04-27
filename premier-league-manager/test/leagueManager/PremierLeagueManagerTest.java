package leagueManager;


import entities.clubs.FootballClub;
import entities.date.Date;
import entities.match.Match;
import leagueManagers.PremierLeagueManager;
import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;


public class PremierLeagueManagerTest {
    public FootballClub footballClub;
    public FootballClub footballClub1;
    public List<FootballClub> footballClubs = new ArrayList<>();
    private List<Match> matchList = new ArrayList<>();
    private Match testMatch;
    private Date date;

    @Before
    public void initialize() {
        date = new Date(2020, 12, 23);
        footballClub = new FootballClub("club test", "test location");
        footballClub1 = new FootballClub("club test1", "test location1");
        testMatch = new Match(footballClub, footballClub1, date, 1, 2, "match win team b");
    }

    @Test
    public void testAddClubToLeague() {
        System.out.println("test add club");
        assertEquals(true, PremierLeagueManager.getInstance().addClubToLeague(footballClub));
        assertEquals(true, PremierLeagueManager.getInstance().addClubToLeague(footballClub1));
        assertEquals(false, PremierLeagueManager.getInstance().addClubToLeague(footballClub1));
        assertEquals(2, PremierLeagueManager.getInstance().getClubCount());
        assertThat(PremierLeagueManager.getInstance().getFootballClubsList(), contains(footballClub, footballClub1));
    }

    @Test
    public void testDisplayStatsOfClub() {
        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        String separator = System.getProperty("line.separator");
        PremierLeagueManager.getInstance().displayStatsOfClub(footballClub);
        assertEquals("+~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~~~~~~+\n" +
                "| Position |     Club name      |  played matches |   w   |   L   |   D   |  S/G  |  R/G  |   Points   |\n" +
                "+~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~~~~~~+\n" +
                "| 1        | club test          | 0               | 0     | 0     | 0     | 0     | 0     | 0          |\n" +
                "+~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~~~~~~+" + separator, os.toString());
        System.setOut(originalOut);
    }

    @Test
    public void testDisplayLeagueTable() {
        PremierLeagueManager.getInstance().addClubToLeague(footballClub);
        PremierLeagueManager.getInstance().addClubToLeague(footballClub1);
        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        String separator = System.getProperty("line.separator");
        PremierLeagueManager.getInstance().displayLeagueTable();
        assertEquals("+~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~~~~~~+\n" +
                "| Position |     Club name      |  played matches |   w   |   L   |   D   |  S/G  |  R/G  |   Points   |\n" +
                "+~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~~~~~~+\n" +
                "| 1        | club test1         | 0               | 0     | 0     | 0     | 0     | 0     | 0          |\n" +
                "+~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~~~~~~+\n" +
                "| 2        | club test          | 0               | 0     | 0     | 0     | 0     | 0     | 0          |\n" +
                "+~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~+~~~~~~~~~~~~+" + separator, os.toString());
        System.setOut(originalOut);
    }

    @Test
    public void testAddMatch() {
        PremierLeagueManager.getInstance().addClubToLeague(footballClub);
        PremierLeagueManager.getInstance().addClubToLeague(footballClub1);
        FootballClub teamA = PremierLeagueManager.getInstance().getFootballClubsList().get(0);
        FootballClub teamB = PremierLeagueManager.getInstance().getFootballClubsList().get(1);

        int teamAScore = testMatch.getTeamAScore();
        int teamBScore = testMatch.getTeamBScore();

        int teamAPlayerMatches = teamA.getNumOfPlayedMatch();
        int teamBPlayerMatches = teamB.getNumOfPlayedMatch();

        int teamANumOfWin = teamA.getNumOfWin();
        int teamANumOfDefeat = teamA.getNumOfDefeat();
        int teamANumOfDraws = teamA.getNumOfDraw();
        int teamAPoints = teamA.getPoint();

        int teamBNumOfWin = teamB.getNumOfWin();
        int teamBNumOfDefeat = teamB.getNumOfDefeat();
        int teamBNumOfDraws = teamB.getNumOfDraw();
        int teamBPoints = teamB.getPoint();
        PremierLeagueManager.getInstance().addMatch(testMatch);
        assertThat(PremierLeagueManager.getInstance().getMatchList(), contains(testMatch));

    }

    @Test
    public void testGetFootballClubsList() {
        PremierLeagueManager.getInstance().addClubToLeague(footballClub);
        PremierLeagueManager.getInstance().addClubToLeague(footballClub1);
        assertThat(PremierLeagueManager.getInstance().getFootballClubsList(), contains(footballClub, footballClub1));
        assertEquals(2, PremierLeagueManager.getInstance().getClubCount());

    }

    @Test
    public void testGetClubCount() {
        PremierLeagueManager.getInstance().addClubToLeague(footballClub);
        PremierLeagueManager.getInstance().addClubToLeague(footballClub1);
        assertEquals(2, PremierLeagueManager.getInstance().getClubCount());
    }

    @Test
    public void testDeleteSportClub() {
        PremierLeagueManager.getInstance().addClubToLeague(footballClub);
        PremierLeagueManager.getInstance().addClubToLeague(footballClub1);
        FootballClub footballClubTest = new FootballClub("club2 test", "test location");
        assertEquals(true, PremierLeagueManager.getInstance().deleteSportClub(footballClub1));
        assertEquals(true, PremierLeagueManager.getInstance().deleteSportClub(footballClub));
        assertEquals(false, PremierLeagueManager.getInstance().deleteSportClub(footballClub));
        assertEquals(false, PremierLeagueManager.getInstance().deleteSportClub(footballClubTest));
    }
}
