import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SignUpInfo } from '../auth/signup-info';
import { UserService } from '../services/user.service';

import { Router } from '@angular/router';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap'; 
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-hr',
  templateUrl: './hr.component.html',
  styleUrls: ['./hr.component.css']
})
export class HRComponent implements OnInit {
  closeResult : string; 
  board: string;
  errorMessage: string;

  users : Observable<SignUpInfo[]>

  constructor(private userService: UserService,  private router: Router , private modalService: NgbModal ,
    private toastr : ToastrService ) { }

    showToastr(){
      this.toastr.success("cc",'tittle');
    }

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
        this.toastr.success("Utilisateur supprimé",'NB');
  }

  
  getUserDetail(id: number){
    this.router.navigate(['details', id]);
  }
  
  //mast7a9ithomch
  open(content) {
    
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  openDetails(targetModal, users: SignUpInfo) {
    this.modalService.open(targetModal, {
     centered: true,
     backdrop: 'static',
     size: 'lg'
   });
    document.getElementById('fname').setAttribute('value', users.name);
    document.getElementById('lname').setAttribute('value', users.username);
    document.getElementById('dept').setAttribute('value', users.cin);
    document.getElementById('email2').setAttribute('value', users.email);
    document.getElementById('cntry').setAttribute('value', users.phone);
 }

  


}
