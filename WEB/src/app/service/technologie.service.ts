import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Technologie } from '../technologie/technologie';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class TechnologieService {

  constructor(private http: HttpClient) { }

  api = 'http://localhost:8083';


  public getTechno(): Observable<Technologie[]>{
    return this.http.get<Technologie[]>(this.api +'/technologies/all');
  }
}
