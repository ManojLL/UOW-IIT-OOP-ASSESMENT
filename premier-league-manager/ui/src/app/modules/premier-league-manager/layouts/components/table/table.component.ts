import {Component, Input, OnInit} from '@angular/core';
import {ITable} from '../../../core/types/table.type';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  @Input() data: ITable[];
  displayedColumns: string[] = ['clubName', 'numOfPlayedMatch', 'numOfWin', 'numOfDefeat','numOfDraw', 'scoredGoal','receivedGoal','point'];

  constructor() {
  }

  ngOnInit(): void {
  }


}
