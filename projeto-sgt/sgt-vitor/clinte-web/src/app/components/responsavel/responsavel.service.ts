import { Injectable } from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient} from "@angular/common/http";
import {Responsavel} from "./responsavel.model";
import {Observable} from "rxjs";



@Injectable({
  providedIn: 'root'
})
export class ResponsavelService {

  baseUrl = "http://localhost:8080/responsaveis"

  constructor(private snakBar: MatSnackBar, private http: HttpClient) { }

  showMenssage(msg:string): void{
    this.snakBar.open(msg,'x',{
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top"
    })
  }
  create(responsavel: Responsavel): Observable<Responsavel>{
    return this.http.post<Responsavel>(this.baseUrl, responsavel)
  }
}
