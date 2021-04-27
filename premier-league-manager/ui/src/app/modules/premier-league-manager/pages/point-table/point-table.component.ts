import {Component, OnInit} from '@angular/core';
import {ITable} from '../../core/types/table.type';
import {TableService} from '../../core/services/tableServices/table.service';
import {MatTabChangeEvent} from "@angular/material/tabs";

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
    this.getLeagueTableAccordingToPoints().then(r => null)

    // this.getLeagueTableAccordingToGoals().then(r => null)

    // this.getLeagueTableAccordingToWins().then(r => null)
  }

  async getLeagueTableAccordingToPoints() {
    try {
      const tableData = await this.tableService.getLeagueTableAccordingToPoints().toPromise();
      this.dataPoint = tableData.response;
      console.log(this.dataPoint)
    } catch (error) {
      console.log(`[ERROR] getAllTableData => ${error.message}`, error);
    }
  }

  async getLeagueTableAccordingToGoals() {
    try {
      const tableData = await this.tableService.getLeagueTableAccordingToGoals().toPromise();
      this.dataGoal = tableData.response;
      console.log(this.dataGoal)
    } catch
      (error) {
      console.log(`[ERROR] getAllTableData => ${error.message}`, error);
    }
  }

  async getLeagueTableAccordingToWins() {
    try {
      const tableData = await this.tableService.getLeagueTableAccordingToWins().toPromise();
      this.dataWin = tableData.response;
    } catch (error) {
      console.log(`[ERROR] getAllTableData => ${error.message}`, error);
    }
  }

  onChange(event
             :
             MatTabChangeEvent
  ) {
    const tab = event.tab.textLabel;
    console.log(tab);
    if (tab == 'ACCORDING TO POINTS') {
      this.getLeagueTableAccordingToPoints();
    }
    if (tab === "ACCORDING TO SCORED GOALS") {
      this.getLeagueTableAccordingToGoals()
    }

    if (tab == 'ACCORDING TO NUMBER OF WINS') {
      this.getLeagueTableAccordingToWins();
    }
  }
}
