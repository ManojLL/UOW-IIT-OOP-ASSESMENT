import {Component, OnInit} from '@angular/core';
import {IMatchType} from '../../core/types/match.type';
import {MatchesService} from "../../core/services/matchService/matches.service";

let data: any = [];

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {
  color = 'primary';
  bgColor = 'accent';
  matchDetails: IMatchType[] = [];

  constructor(private matchesService: MatchesService) {
  }

  ngOnInit(): void {
    this.getAllMatchesDetails();
  }

  async getAllMatchesDetails() {
    try {
      const matches = await this.matchesService.getMatchDetails().toPromise();
      if (matches.status) {
        data = matches.response.map(match => {
          return {
            teamA: match.teamA.clubName,
            teamB: match.teamB.clubName,
            teamAScore: match.teamAScore,
            teamBScore: match.teamBScore,
            date: match.date.year.toString() + "/" + match.date.month.toString() + "/" + match.date.day.toString(),
            status: match.status
          }
        })
        this.matchDetails = data
      }
    } catch (error) {
      console.log(`[ERROR] getAllTableData => ${error.message}`, error);
    }

  }
}
