import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ITable} from '../../types/table.type';
import {environment} from '../../../../../../environments/environment';

@Injectable({
  providedIn: 'any'
})
export class TableService {
  TABLE_API_URL = `${environment.API_BASE_URL}/api/tables`;

  constructor(private httpClient: HttpClient) {
  }

  getLeagueTableAccordingToPoints() {
    return this.httpClient.get<any>(this.TABLE_API_URL + "/points")
  }

  getLeagueTableAccordingToGoals() {
    return this.httpClient.get<any>(this.TABLE_API_URL + "/goals")
  }

  getLeagueTableAccordingToWins() {
    return this.httpClient.get<any>(this.TABLE_API_URL + "/wins")
  }

}
