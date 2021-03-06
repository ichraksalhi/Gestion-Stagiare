import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = 'http://localhost:8083/api/test/user';
  private encadrantUrl = 'http://localhost:8083/api/test/pm';
  private HRUrl = 'http://localhost:8083/api/test/admin';
  //private listUrl = 'http://localhost:8083/afficher'

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

  getUserList(): Observable<any> {
    return this.http.get(`${this.HRUrl}/afficher`);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.HRUrl}/delete/${id}`, { responseType: 'text' });
  }

  getUserDetail(id: number): Observable<any> {
    return this.http.get(`${this.HRUrl}/detail/${id}`);
  }
  // amin affichage avec condition  etape 3

}
