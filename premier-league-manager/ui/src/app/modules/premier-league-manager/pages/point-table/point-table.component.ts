import {Component, OnInit} from '@angular/core';
import {ITable} from '../../core/types/table.type';
import {TableService} from '../../core/services/tableServices/table.service';

@Component({
  selector: 'app-point-table',
  templateUrl: './point-table.component.html',
  styleUrls: ['./point-table.component.css']
})
export class PointTableComponent implements OnInit {
  dataPoint: ITable[] = [];
  dataGoal: ITable[] = [];
  dataWin: ITable[] = [];
  color = 'primary';
  bgColor = 'accent';

  constructor(private tableService: TableService) {
  }

  ngOnInit(): void {
    this.getLeagueTableAccordingToPoints()
    this.getLeagueTableAccordingToGoals()
    this.getLeagueTableAccordingToWins()
  }

  async getLeagueTableAccordingToPoints() {
    try {
      const tableData = await this.tableService.getLeagueTableAccordingToPoints().toPromise();
      console.log(tableData.status)
      this.dataPoint = tableData.response;
    } catch (error) {
      console.log(`[ERROR] getAllTableData => ${error.message}`, error);
    }
  }

  async getLeagueTableAccordingToGoals() {
    try {
      const tableData = await this.tableService.getLeagueTableAccordingToGoals().toPromise();
      console.log(tableData.status)
      this.dataGoal = tableData.response;
    } catch (error) {
      console.log(`[ERROR] getAllTableData => ${error.message}`, error);
    }
  }

  async getLeagueTableAccordingToWins() {
    try {
      const tableData = await this.tableService.getLeagueTableAccordingToWins().toPromise();
      console.log(tableData.status)
      this.dataWin = tableData.response;
    } catch (error) {
      console.log(`[ERROR] getAllTableData => ${error.message}`, error);
    }
  }
}
