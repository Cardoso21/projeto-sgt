import { Injectable } from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient} from "@angular/common/http";
import {Responsavel} from "./responsavel.model";
import {Observable} from "rxjs";
import {Router} from "@angular/router";




@Injectable({
  providedIn: 'root'
})
export class ResponsavelService {

  baseUrl = "http://localhost:8080/responsaveis"

  constructor(private snakBar: MatSnackBar, private http: HttpClient,private router: Router) {
  }

  findAll():Observable<Responsavel[]>{
    return this.http.get<Responsavel[]>(this.baseUrl);
  }

  showMenssage(msg: string): void {
    this.snakBar.open(msg, 'x', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top"
    })
  }

  create(responsavel: Responsavel): Observable<Responsavel> {
    return this.http.post<Responsavel>(this.baseUrl, responsavel);
  }

  readById(id:string): Observable<Responsavel>{
    const url = `${this.baseUrl}/${id}`
    return this.http.get<Responsavel>(url)
    }
  update(responsavel:Responsavel):  Observable<Responsavel>{
    const url = `${this.baseUrl}/${responsavel.id}`
    return this.http.put<Responsavel>(url, responsavel)
  }
  delete(id:string): Observable<Responsavel>{
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<Responsavel>(url);
  }
}

