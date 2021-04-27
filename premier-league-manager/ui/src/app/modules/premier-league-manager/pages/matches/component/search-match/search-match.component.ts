import {Component, OnInit} from '@angular/core';
import {IDate} from '../../../../core/types/date.type';
import {IMatchType} from "../../../../core/types/match.type";
import {MatchesService} from "../../../../core/services/matchService/matches.service";

let month: number;
let year: number;
let day: number;
let data: any;

@Component({
  selector: 'app-search-match',
  templateUrl: './search-match.component.html',
  styleUrls: ['./search-match.component.css']
})
export class SearchMatchComponent implements OnInit {
  matchDetails: IMatchType[] = [];

  searchDate: IDate;
  find: boolean;

  constructor(private matchesService: MatchesService) {
  }

  ngOnInit(): void {
    //todo : get current date
  }


  validateMonth(value: number) {
    if (value > 0 && value <= 12) {
      month = value;
      return true;
    }
    alert("month is not valid")
    return false;
  }

  validateDay(value: number) {
    if (value > 0 && value <= 31) {
      day = value;
      return true;
    }
    alert("month is not valid")
    return false;
  }

  async searchingMatches(year: number, month: number, day: number) {
    if (this.validateDay(day) && this.validateMonth(month)) {
      this.searchDate = {
        year: year,
        month: month,
        day: day
      }
      this.matchDetails = [];
      try {
        const matches = await this.matchesService.searchMatch(this.searchDate).toPromise();
        if (matches.status) {
          this.find = true;
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
        } else {
          alert("no match found to this date")
        }
      } catch (error) {
        console.log(`[ERROR] getAllTableData => ${error.message}`, error);
        alert("no match found to this date")
      }
    }
  }
}
