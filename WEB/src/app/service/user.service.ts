import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../user/user';



@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = 'http://localhost:8080/api/test/user';
  private encadrantUrl = 'http://localhost:8080/api/test/pm';
  private HRUrl = 'http://localhost:8080/api/test/admin';
  api = 'http://localhost:8080';

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

  //affichage stagiaires actives 
  public getUsers(): Observable<User[]>{
    return this.http.get<User[]>(this.api +'/users/active');
  }

  public getAllUsers(): Observable<User[]>{
    return this.http.get<User[]>(this.api +'/users/all');
  }
  getUserList(): Observable<any> {
    return this.http.get(`${this.HRUrl}/afficher`);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.HRUrl}/delete/${id}`, { responseType: 'text' });
  }

  getUserDetail(id: number): Observable<any> {
    return this.http.get(`${this.HRUrl}/detail/${id}`);
  }
}
