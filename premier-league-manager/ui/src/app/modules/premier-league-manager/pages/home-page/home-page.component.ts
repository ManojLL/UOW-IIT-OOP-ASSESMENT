import {Component, OnInit} from '@angular/core';
import {ITable} from '../../core/types/table.type';
import {TableService} from '../../core/services/tableServices/table.service';
import {MatchesService} from '../../core/services/matchService/matches.service';
import {IMatchType} from '../../core/types/match.type';
import {Observable} from "rxjs";


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})

export class HomePageComponent implements OnInit {
  data: ITable[] = [];
  matchDetails: IMatchType[] = [];

  constructor(private tableService: TableService, private matchService: MatchesService) {
  }

  ngOnInit(): void {
    this.getAllTableData();
  }


  async getAllTableData() {
    try {
      const tableData = await this.tableService.getLeagueTableAccordingToPoints().toPromise();
      console.log(tableData.status)
      this.data = tableData.response;
    } catch (error) {
      console.log(`[ERROR] getAllTableData => ${error.message}`, error);
    }
  }

  getMatchDetails() {
    // this.matchService.getMatchDetails();
  }
}

