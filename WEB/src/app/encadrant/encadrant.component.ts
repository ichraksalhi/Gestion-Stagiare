import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SignUpInfo } from '../auth/signup-info';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-encadrant',
  templateUrl: './encadrant.component.html',
  styleUrls: ['./encadrant.component.css']
})
export class EncadrantComponent implements OnInit {

  board: string;
  errorMessage: string;
    users : Observable<SignUpInfo[]>
    
  constructor(private userService: UserService,  private router: Router ) { } 

  ngOnInit() {
    this.userService.getPMBoard().subscribe(
      data => {
        this.board = data;
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  }
  

  
  reloadData() {
    this.users = this.userService.getStagairelist();
  }
  
  deleteUser(id: number) {
    this.userService.deleteUser(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  
  getUserDetail(id: number){
    this.router.navigate(['details', id]);
  }
}


  //getStagairelist() {
    //this.users = this.userService. getStagairelist(); }

