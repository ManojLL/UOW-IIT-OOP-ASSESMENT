import {Component, OnInit} from '@angular/core';
import {IMatchType} from '../../core/types/match.type';

const matchData: IMatchType[] = [
  {teamA: 'team A', teamB: 'teamB', teamBScore: 1, teamAScore: 3, date: '2020/2/2/', status: 'match win team a'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 2, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 3, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 4, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 5, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 6, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 7, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 8, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 9, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 10, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 11, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 12, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 13, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 14, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 15, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 16, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 7, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
];

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {
  color = 'primary';
  bgColor = 'accent';
  matchDetails: IMatchType[] = matchData;

  constructor() {
  }

  ngOnInit(): void {
  }

}
