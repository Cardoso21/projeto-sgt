import { Component, OnInit } from '@angular/core';
import {TarefasService} from "../tarefas.service";
import {Router} from "@angular/router";
import {Tarefas} from "../tarefas.model";

@Component({
  selector: 'app-tarefas-create',
  templateUrl: './tarefas-create.component.html',
  styleUrls: ['./tarefas-create.component.css']
})
export class TarefasCreateComponent implements OnInit {

  tarefa: Tarefas = {
    id: '',
    titulo: '',
    dataInicial: '',
    dataPrevista: '',
    dataEfetiva: '',
    tipoTarefa: '',
    status: '',
    idResponsavel:''

  }

  constructor(private tarefasService: TarefasService,
              private router: Router) { }

  ngOnInit(): void {

  }

  createTarefas(): void {
    this.tarefasService.create(this.tarefa).subscribe(() => {
      this.tarefasService.showMessege('Tarefa criada!!')
      this.router.navigate(['/Tarefa'])
    })

  }
  cancel(): void {
    this.router.navigate(['/Tarefa'])
  }
}
