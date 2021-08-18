import { Injectable } from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient} from "@angular/common/http";
import {Tarefa} from "./tarefas.model";
import {Observable} from "rxjs";
import {Router} from "@angular/router";


@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  baseUrl = "http://localhost:8080/tarefas";

  constructor(private snackBar: MatSnackBar, private http: HttpClient, private router: Router) {
  }

  findAll():Observable<Tarefa[]>{
    return this.http.get<Tarefa[]>(this.baseUrl);
  }

  showMessege(msg: string): void {
    this.snackBar.open(msg, 'x', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
    })
  }

  create(tarefa: Tarefa): Observable<Tarefa> {
    return this.http.post<Tarefa>(this.baseUrl, tarefa)
  }

  readById(id:string): Observable<Tarefa>{
    const url = `${this.baseUrl}/${id}`
    return this.http.get<Tarefa>(url)
  }

  update(tarefa:Tarefa): Observable<Tarefa> {
    const url = `${this.baseUrl}/${tarefa.id}`
    return this.http.put<Tarefa>(url, tarefa)
  }

  delete(id: string):Observable<Tarefa>{
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<Tarefa>(url);
  }

}