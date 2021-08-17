import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
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

//import {  CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';




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
    UserComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders],
  
  bootstrap: [AppComponent]
  //schemas: [CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
