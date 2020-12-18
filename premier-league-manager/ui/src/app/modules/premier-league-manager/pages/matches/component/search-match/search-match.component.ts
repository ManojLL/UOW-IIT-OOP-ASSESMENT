import {Component, OnInit} from '@angular/core';
import {IDate} from '../../../../core/types/date.type';
import {MatDialog} from '@angular/material/dialog';
import {AltertsComponent} from './component/alterts/alterts.component';


@Component({
  selector: 'app-search-match',
  templateUrl: './search-match.component.html',
  styleUrls: ['./search-match.component.css']
})
export class SearchMatchComponent implements OnInit {
  currentDate: IDate = {
    year: 2020,
    month: 12,
    day: 12,
  };

  constructor(private dialog: MatDialog) {
  }

  ngOnInit(): void {
    //todo : get current date
  }

  openDialog(name: string): void {
    this.dialog.open(AltertsComponent, {
      data: name
    });
  }
}
