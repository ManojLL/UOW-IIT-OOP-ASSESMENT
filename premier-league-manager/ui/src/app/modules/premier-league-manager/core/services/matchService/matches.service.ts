import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../../../../environments/environment';

@Injectable({
  providedIn: 'any'
})
export class MatchesService {
  MATCH_API_URL = `${environment.API_BASE_URL}`;

  constructor(private httpClient: HttpClient) {
  }

  getMatchDetails() {
    // todo
  }
}
