import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-hr',
  templateUrl: './hr.component.html',
  styleUrls: ['./hr.component.css']
})
export class HRComponent implements OnInit {
  board: string;
  errorMessage: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getHRBoard().subscribe(
      data => {
        this.board = data;
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  
  }

}
