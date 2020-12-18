import {Component, Input, OnInit} from '@angular/core';
import {IMatchType} from '../../../core/types/match.type';

@Component({
  selector: 'app-match-card',
  templateUrl: './match-card.component.html',
  styleUrls: ['./match-card.component.css']
})
export class MatchCardComponent implements OnInit {
  @Input() matchDetails: IMatchType;

  constructor() {
  }

  ngOnInit(): void {
  }

}
