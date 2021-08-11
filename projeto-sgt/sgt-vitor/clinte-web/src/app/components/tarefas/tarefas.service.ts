import { Injectable } from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient} from "@angular/common/http";
import {Tarefas} from "./tarefas.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  baseUrl = "http://localhost:8080/tarefas"

  constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

  showMessege(msg:string): void{
    this.snackBar.open(msg,'x',{
      duration: 3000,
      horizontalPosition:"right",
      verticalPosition: "top",
    })
  }

  create(tarefa: Tarefas): Observable<Tarefas>{
    return this.http.post<Tarefas>(this.baseUrl, tarefa)
  }
}
