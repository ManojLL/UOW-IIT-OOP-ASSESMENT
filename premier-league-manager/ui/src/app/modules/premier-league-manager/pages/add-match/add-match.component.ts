import {Component, OnInit} from '@angular/core';
import {IMatchType} from '../../core/types/match.type';
import {MatchesService} from "../../core/services/matchService/matches.service";

@Component({
  selector: 'app-add-match',
  templateUrl: './add-match.component.html',
  styleUrls: ['./add-match.component.css']
})
export class AddMatchComponent implements OnInit {
  newMatchData: IMatchType;
  matchCreated = false;

  constructor(private matchesService: MatchesService) {
  }

  ngOnInit(): void {
  }

  async createMatch() {
    try {
      const match = await this.matchesService.createRandomMatch().toPromise();
      this.matchCreated = match.status
      if (this.matchCreated) {
        this.newMatchData = {
          teamA: match.response.teamA.clubName,
          teamB: match.response.teamB.clubName,
          teamAScore: match.response.teamAScore,
          teamBScore: match.response.teamBScore,
          date: match.response.date.year.toString() + "/" + match.response.date.month.toString() + "/" + match.response.date.day.toString(),
          status: match.response.status
        }
      }
    } catch (error) {
      console.log(`[ERROR] getAllTableData => ${error.message}`, error);
      alert("no clubs to make a match");
    }
  }
}
