import {Component, OnInit} from '@angular/core';
import {IMatchType} from '../../core/types/match.type';

@Component({
  selector: 'app-add-match',
  templateUrl: './add-match.component.html',
  styleUrls: ['./add-match.component.css']
})
export class AddMatchComponent implements OnInit {
  newMatchData: IMatchType;
  matchCreated = false;

  constructor() {
  }

  ngOnInit(): void {
  }

  createMatch(): void {
    // todo call createMatch
    this.newMatchData = {
      teamB: 'aj',
      teamA: 's',
      teamAScore: 1,
      teamBScore: 3,
      status: 'hjbjvjv',
      date: 'dqdq'
    };
    this.matchCreated = true;
  }
}
