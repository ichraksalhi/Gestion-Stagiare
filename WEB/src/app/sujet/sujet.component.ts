import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SujetService } from '../service/sujet.service';
import { TokenStorageService } from '../auth/token-storage.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Technologie } from '../technologie/technologie';
import { TechnologieService } from '../service/technologie.service';
import { User } from '../user/user';
import { UserService } from '../service/user.service';





@Component({
  selector: 'sujet',
  templateUrl: './sujet.component.html',
  styleUrls: ['./sujet.component.css']
})
export class SujetComponent implements OnInit{
  allTechnologies: Technologie[];
  allUsers: User[];


  constructor(private sujetService: SujetService, private token: TokenStorageService, private technologieService: TechnologieService, private userService: UserService){}


  info: any;

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };
    this.getTechno();
    this.getAllUsers();
  }
  public getTechno(): void {
    this.technologieService.getTechno().subscribe(
      (response: Technologie[]) => {
        this.allTechnologies = response;
        console.log(this.allTechnologies);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllUsers(): void {
    this.userService.getAllUsers().subscribe(
      (response: User[]) => {
        this.allUsers = response;
        console.log(this.allUsers);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  title = 'sujet';

  sujetDetails = null as any;

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
