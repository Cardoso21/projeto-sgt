import { Component, OnInit } from '@angular/core';
import {Responsavel} from "../responsavel.model";
import {ResponsavelService} from "../responsavel.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-responsavel-delete',
  templateUrl: './responsavel-delete.component.html',
  styleUrls: ['./responsavel-delete.component.css']
})
export class ResponsavelDeleteComponent implements OnInit {

  idupdate=''
  responsavel: Responsavel= {
    id: '',
    nome: '',
    email: ''
  }
  constructor(private responsavelService : ResponsavelService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.idupdate = this.route.snapshot.paramMap.get('id')!
    this.responsavelService.readById(this.idupdate).subscribe(resposta =>{
      this.responsavel=resposta
    });
  }
  apagar(): void{
    this.responsavelService.delete(this.idupdate).subscribe(()=>{
      this.responsavelService.showMenssage('Responsavel excuido com sucesso!')
      this.router.navigate(['Responsavel']);
    })
  }

  cancel(): void{
    this.router.navigate(['Responsavel']);
  }

}
