import {Component, OnInit} from '@angular/core';
import {ITable} from '../../core/types/table.type';

const ELEMENT_DATA: ITable[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
];

@Component({
  selector: 'app-point-table',
  templateUrl: './point-table.component.html',
  styleUrls: ['./point-table.component.css']
})
export class PointTableComponent implements OnInit {
  data = ELEMENT_DATA;
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  color = 'primary';
  bgColor = 'accent';

  constructor() {
  }

  ngOnInit(): void {
  }

}
