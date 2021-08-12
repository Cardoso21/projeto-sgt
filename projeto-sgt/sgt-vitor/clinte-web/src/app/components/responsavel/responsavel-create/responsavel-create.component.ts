import { Component, OnInit } from '@angular/core';
import {ResponsavelService} from "../responsavel.service";
import {Router} from "@angular/router";
import {Responsavel} from "../responsavel.model";


@Component({
  selector: 'app-responsaveis-create',
  templateUrl: './responsavel-create.component.html',
  styleUrls: ['./responsavel-create.component.css']
})
export class ResponsavelCreateComponent implements OnInit {

  responsavel: Responsavel ={

    id: '',
    nome: '',
    email: ''
  }

  constructor(private responsavelService: ResponsavelService,
              private router: Router) { }

  ngOnInit(): void {

  }
  createResponsavel(): void{
    this.responsavelService.create(this.responsavel).subscribe(()=>{
      this.responsavelService.showMenssage('Responsavel criado!')
      this.router.navigate(['Responsavel'])
    })

  }

  cancel(): void{
    this.router.navigate(['Responsavel'])
  }

}
