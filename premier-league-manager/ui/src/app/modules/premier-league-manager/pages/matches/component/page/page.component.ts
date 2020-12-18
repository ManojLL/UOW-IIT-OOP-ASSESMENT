import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {IMatchType} from '../../../../core/types/match.type';



@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {
  @Input()matchDetails: IMatchType[];
  config: any;

  constructor() {
  }

  ngOnInit() {
    this.config = {
      currentPage: 1,
      itemsPerPage: 5,
    };
  }

  pageChanged(pageNumber: number) {
    this.config.currentPage = pageNumber;
  }
}

