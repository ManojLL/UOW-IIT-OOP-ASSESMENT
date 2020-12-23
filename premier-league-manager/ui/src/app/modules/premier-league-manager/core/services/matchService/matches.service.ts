import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../../../../environments/environment';
import {IMatchType} from "../../types/match.type";
import {IDate} from "../../types/date.type";

@Injectable({
  providedIn: 'any'
})
export class MatchesService {
  MATCH_API_URL = `${environment.API_BASE_URL}/api/matches`;

  constructor(private httpClient: HttpClient) {
  }

  getMatchDetails() {
    return this.httpClient.get<any>(this.MATCH_API_URL + "/allMatches")
  }

  getSearchedMatches() {
    //todo
  }

  createRandomMatch() {
    return this.httpClient.post<any>(this.MATCH_API_URL + "/random", {});
  }

  searchMatch(date: IDate) {
    return this.httpClient.get<any>(this.MATCH_API_URL +"/search"+ "/" + date.year + "/" + date.month + "/" + date.day)
  }
}
