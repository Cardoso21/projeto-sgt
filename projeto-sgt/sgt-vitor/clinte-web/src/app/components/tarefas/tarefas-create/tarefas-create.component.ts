import { Component, OnInit } from '@angular/core';
import {TarefasService} from "../tarefas.service";
import {Router} from "@angular/router";
import {Tarefa} from "../tarefas.model";


interface DatepickerOverviewExample {
}

@Component({
  selector: 'app-tarefas-create',
  templateUrl: './tarefas-create.component.html',
  styleUrls: ['./tarefas-create.component.css'],

})
export class TarefasCreateComponent implements DatepickerOverviewExample {
  dtInicial: Date= new Date();
  dtPrevista: Date= new Date();
  dtEfetiva: Date= new Date();

  tarefa: Tarefa= {
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
    this.tarefa.dataInicial=this.dtInicial.toISOString()
    this.tarefa.dataPrevista=this.dtPrevista.toISOString()
    this.tarefa.dataEfetiva=this.dtEfetiva.toISOString()
    this.tarefasService.create(this.tarefa).subscribe(() => {
      this.tarefasService.showMessege('Tarefa criada!!')
      this.router.navigate(['Tarefa'])
    })

  }
  cancel(): void {
    this.router.navigate(['Tarefa'])
  }
}