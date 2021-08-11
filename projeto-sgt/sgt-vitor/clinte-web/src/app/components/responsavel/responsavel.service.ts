import { Injectable } from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";


@Injectable({
  providedIn: 'root'
})
export class ResponsavelService {

  constructor(private snakBar: MatSnackBar) { }

  showMenssage(msg:string): void{
    this.snakBar.open(msg,'x',{
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top"
    })
  }
}
