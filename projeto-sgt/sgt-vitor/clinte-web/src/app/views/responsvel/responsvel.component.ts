import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";


@Component({
  selector: 'app-responsvel',
  templateUrl: './responsvel.component.html',
  styleUrls: ['./responsvel.component.css']
})
export class ResponsvelComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

    navigateToResponsaveisCreate(): void{
      this.router.navigate(['/responsavel/create'])
    }
}
