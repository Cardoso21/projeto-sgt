import { Component, OnInit } from '@angular/core';
import {ResponsavelService} from "../responsavel.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-responsaveis-create',
  templateUrl: './responsavel-create.component.html',
  styleUrls: ['./responsavel-create.component.css']
})
export class ResponsavelCreateComponent implements OnInit {

  constructor(private responsavelService: ResponsavelService,
              private router: Router) { }

  ngOnInit(): void {

  }
  createResponsavel(): void{
    this.responsavelService.showMenssage('Responsavel criado!')
  }

  cancel(): void{
    this.router.navigate(['responsavel'])
  }

}
