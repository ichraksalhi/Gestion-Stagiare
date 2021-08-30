import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { Technologie } from './technologie';
import { TechnologieService } from '../service/technologie.service';

@Component({
  selector: 'app-technologie',
  templateUrl: './technologie.component.html',
  styleUrls: ['./technologie.component.css']
})
export class TechnologieComponent implements OnInit {
  info: any;
  technologies: Technologie[];

  constructor(private technologieService: TechnologieService, private token: TokenStorageService) { }

  ngOnInit(): void {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    }
    this.getTechno();
  }


  public getTechno(): void {
    this.technologieService.getTechno().subscribe(
      (response: Technologie[]) => {
        this.technologies = response;
        console.log(this.technologies);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  

}
