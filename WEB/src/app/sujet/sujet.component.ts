import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SujetService } from './sujet.service';
import { TokenStorageService } from '../auth/token-storage.service';



@Component({
  selector: 'sujet',
  templateUrl: './sujet.component.html',
  styleUrls: ['./sujet.component.css']
})
export class SujetComponent implements OnInit{

  constructor(private sujetService: SujetService, private token: TokenStorageService){}

  info: any;

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };
  }

  title = 'sujet';

  sujetDetails = null as any;
  sujetToUpdate = {
    idSujet:"",
    sujetName:"",
    sujetDescription:"",
    sujetTechnologies:"",
    sujetStagiaires:""

  }



  add(sujetForm: NgForm){
    this.sujetService.addSujet(sujetForm.value).subscribe(
      (resp) => {
        console.log(resp);
        sujetForm.reset();
      },
      (err) => {
        console.log(err);
      }
    );
  }

}


