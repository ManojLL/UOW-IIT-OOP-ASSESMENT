import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ITable} from '../../types/table.type';
import {environment} from '../../../../../../environments/environment';

@Injectable({
  providedIn: 'any'
})
export class TableService {
  TABLE_API_URL = `${environment.API_BASE_URL}`;

  constructor(private httpClient: HttpClient) {
  }

  getAllClubsDetails() {
    //TODO: complete this servoce;
    // return this.httpClient.get<ITable[]>(this.TABLE_API_URL);
  }
}
