import { Component, OnInit } from '@angular/core';
import {TarefasService} from "../tarefas.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Tarefa} from "../tarefas.model";

@Component({
  selector: 'app-tarefas-delete',
  templateUrl: './tarefas-delete.component.html',
  styleUrls: ['./tarefas-delete.component.css']
})
export class TarefasDeleteComponent implements OnInit {

  idupdate= ''
  tarefa: Tarefa= {
    id: '',
    titulo: '',
    dataInicial: '',
    dataPrevista: '',
    dataEfetiva: '',
    tipoTarefa: '',
    status: '',
    idResponsavel: ''
  }
  constructor(private tarafaService: TarefasService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.idupdate = this.route.snapshot.paramMap.get('id')!
    this.tarafaService.readById(this.idupdate).subscribe(resposta =>{
      this.tarefa= resposta
    });
  }
apagar(): void{
      this.tarafaService.delete(this.idupdate).subscribe(() =>{
          this.tarafaService.showMessege('Tarefa excluida com sucesso!')
          this.router.navigate(['Tarefa']);
      })
  }
  cancel(): void{
    this.router.navigate(['Tarefa']);

  }
}
