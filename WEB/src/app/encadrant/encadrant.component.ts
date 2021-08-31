import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SignUpInfo } from '../auth/signup-info';
import { UserService } from '../service/user.service';

import { Router } from '@angular/router';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { TokenStorageService } from '../auth/token-storage.service';
import {User} from '../user/user';

@Component({
  selector: 'app-encadrant',
  templateUrl: './encadrant.component.html',
  styleUrls: ['./encadrant.component.css']
})
export class EncadrantComponent implements OnInit {
  closeResult : string;
  board: string;
  errorMessage: string;
  info: any;

  users : Observable<User[]>

  constructor(private userService: UserService,  private router: Router ) { }


  ngOnInit(): void {
    this.userService.getPMBoard().subscribe(
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
    this.users = this.userService.getByRoles_Name();
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

