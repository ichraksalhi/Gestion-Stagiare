import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';

import { HRComponent } from './hr/hr.component';
import { EncadrantComponent } from './encadrant/encadrant.component';
import { SujetComponent } from './sujet/sujet.component';
//import { AdminComponent } from './admin/admin.component';

const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'user',
        component: UserComponent      
    },
    {
        path: 'users/active',
        component: UserComponent      
    },

    {
        path: 'hr',
        component: HRComponent      
    },
    {
        path: 'encadrant',
        component: EncadrantComponent
    },
    
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: 'sujets/ajouter',
        component: SujetComponent
    },
    {
        path: '',
        redirectTo: 'auth/login',
        pathMatch: 'full'
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
