import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ITable} from '../../core/types/table.type';
import {TableService} from '../../core/services/tableServices/table.service';
import {MatchesService} from '../../core/services/matchService/matches.service';
import {IMatchType} from '../../core/types/match.type';

const ELEMENT_DATA: ITable[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
];
const matchData: IMatchType[] = [
  {teamA: 'team A', teamB: 'teamB', teamBScore: 2, teamAScore: 3, date: '2020/2/2/', status: 'match win team a'},
  {teamA: 'team A', teamB: 'teamB', teamBScore: 2, teamAScore: 3, date: '2020/2/2/', status: 'match win team b'},
];

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})

export class HomePageComponent implements OnInit {
  tableData = '';
  data = ELEMENT_DATA;
  matchDetails = matchData;

  constructor(private router: Router, private tableService: TableService, private matchService: MatchesService) {
  }

  ngOnInit(): void {
    this.getAllTableData();
  }

  changeRoute = (route: string) => {
    this.router.navigateByUrl(route);
  };

  getAllTableData() {
    // try {
    // } catch (error) {
    //   console.log(`[ERROR] getAllTableData => ${error.message}`, error);
    // }
  }

  getMatchDetails() {
   // this.matchService.getMatchDetails();
  }
}

