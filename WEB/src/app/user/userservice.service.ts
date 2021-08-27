import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private http: HttpClient) { }

  API = 'http://localhost:8083';

  public getUser() {
    return this.http.get(this.API + '/users/all');
  }
}
