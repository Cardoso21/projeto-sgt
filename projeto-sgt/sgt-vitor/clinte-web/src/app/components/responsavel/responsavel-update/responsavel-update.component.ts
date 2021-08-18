import { Component, OnInit } from '@angular/core';
import {Responsavel} from "../responsavel.model";
import {ResponsavelService} from "../responsavel.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-responsavel-update',
  templateUrl: './responsavel-update.component.html',
  styleUrls: ['./responsavel-update.component.css']
})
export class ResponsavelUpdateComponent implements OnInit {

    idupdate=''
    responsavel: Responsavel={
      id: '',
      nome: '',
      email: ''
    }

  constructor(private responsavelService: ResponsavelService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
      this.idupdate = this.route.snapshot.paramMap.get('id')!
    this.responsavelService.readById(this.idupdate).subscribe(resposta =>{
      this.responsavel = resposta
    });
  }
  updateResponsavel():void{
      this.responsavelService.update(this.responsavel).subscribe(()=>{
          this.responsavelService.showMenssage('Responsavel atualizado com sucesso!')
          this.router.navigate([this.responsavel]);
      })
  }

  cancel(): void{
        this.router.navigate(['Responsavel'])
  }

}
