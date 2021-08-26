import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';



@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = 'http://localhost:8083/api/test/user';
  private encadrantUrl = 'http://localhost:8083/api/test/pm';
  private HRUrl = 'http://localhost:8083/api/test/admin';
  api = 'http://localhost:8083';

  constructor(private http: HttpClient) { }

  getUserBoard(): Observable<string> {
    return this.http.get(this.userUrl, { responseType: 'text' });
  }

  getPMBoard(): Observable<string> {
    return this.http.get(this.encadrantUrl, { responseType: 'text' });
  }

  getHRBoard(): Observable<string> {
    return this.http.get(this.HRUrl, { responseType: 'text' });
  }

  public getUsers(): Observable<User[]>{
    return this.http.get<User[]>(this.api +'/users/active');
  }
}
