import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SujetService {

  constructor(private Http : HttpClient) { }

  API = 'http://localhost:8083';

  public addSujet(sujetData: any){
    return this.Http.post(this.API + '/sujets/add', sujetData)
  }
}
