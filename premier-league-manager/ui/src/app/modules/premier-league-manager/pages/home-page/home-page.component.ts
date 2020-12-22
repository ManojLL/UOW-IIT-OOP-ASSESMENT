import {Component, OnInit} from '@angular/core';
import {ITable} from '../../core/types/table.type';
import {TableService} from '../../core/services/tableServices/table.service';
import {MatchesService} from '../../core/services/matchService/matches.service';



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})

export class HomePageComponent implements OnInit {


  constructor(private tableService: TableService, private matchService: MatchesService) {
  }

  ngOnInit(): void {
  }


  getMatchDetails() {
    // this.matchService.getMatchDetails();
  }
}

