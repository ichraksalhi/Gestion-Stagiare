import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ContentComponent } from './content/content.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { HRComponent } from './hr/hr.component';
import { EncadrantComponent } from './encadrant/encadrant.component';
import { UserComponent } from './user/user.component';


import { httpInterceptorProviders } from './auth/auth-interceptor';
import { UserService } from './service/user.service';
import { ToastModule } from 'primeng/toast';
import { MultiSelectModule } from 'primeng/multiselect';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { SujetComponent } from './sujet/sujet.component';
import { NgModule } from '@angular/core';

import {  CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { TechnologieComponent } from './technologie/technologie.component';
import { StageComponent } from './stage/stage.component';
import { SujetsComponent } from './sujets/sujets.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    ContentComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    HRComponent,
    EncadrantComponent,
    UserComponent,
    SujetComponent,
    TechnologieComponent,
    StageComponent,
    SujetsComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ToastModule,
    MultiSelectModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    NgbModule
  ],
  providers: [httpInterceptorProviders],

  bootstrap: [AppComponent],

  schemas: [CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
