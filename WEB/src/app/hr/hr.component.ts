import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SignUpInfo } from '../auth/signup-info';
import { UserService } from '../services/user.service';

import { Router } from '@angular/router';

@Component({
  selector: 'app-hr',
  templateUrl: './hr.component.html',
  styleUrls: ['./hr.component.css']
})
export class HRComponent implements OnInit {
  board: string;
  errorMessage: string;

  users : Observable<SignUpInfo[]>

  constructor(private userService: UserService,  private router: Router ) { }

  ngOnInit(): void {
    this.userService.getHRBoard().subscribe(
      data => {
        this.board = data;
        this.reloadData();
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  
  
  }

  reloadData() {
    this.users = this.userService.getUserList();
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
