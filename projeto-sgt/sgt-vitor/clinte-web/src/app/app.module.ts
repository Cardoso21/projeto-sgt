import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/templete/header/header.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import { FooterComponent } from './components/templete/footer/footer.component';
import { NavComponent } from './components/templete/nav/nav.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import { HomeComponent } from './views/home/home.component';
import {MatCardModule} from "@angular/material/card";
import { TarefasComponent } from './views/tarefas/tarefas.component';
import { ResponsvelComponent } from './views/responsvel/responsvel.component';
import { TarefasCreateComponent } from './components/tarefas/tarefas-create/tarefas-create.component';
import {MatButtonModule} from "@angular/material/button";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from '@angular/forms';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import { ResponsavelCreateComponent } from './components/responsavel/responsavel-create/responsavel-create.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    TarefasComponent,
    ResponsvelComponent,
    TarefasCreateComponent,
    ResponsavelCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    MatSnackBarModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
