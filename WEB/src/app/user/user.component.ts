import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { UserService } from '../services/user.service';
import { SignUpInfo } from '../auth/signup-info';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users : Observable<SignUpInfo[]>

  constructor( private userService : UserService, private router : Router ) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.users = this.userService.getUserList();
  }

}
