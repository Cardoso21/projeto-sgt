import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Responsavel} from "../responsavel.model";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {ResponsavelService} from "../responsavel.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-responsavel-read',
  templateUrl: './responsavel-read.component.html',
  styleUrls: ['./responsavel-read.component.css']
})
export class ResponsavelReadComponent implements AfterViewInit {

  res: Responsavel []=[];

  displayedColumns:  string[] = ['id','nome','email', 'action'];
  dataSource = new MatTableDataSource<Responsavel>(this.res);

  @ViewChild(MatPaginator) paginator!: MatPaginator;


  constructor(private service: ResponsavelService, ) {

  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.findAll();
  }
  findAll(): void{
    this.service.findAll().subscribe((resposta)=>{
      this.res =resposta;
      console.log(resposta)
      this.dataSource = new MatTableDataSource<Responsavel>(this.res);
      this.dataSource.paginator = this.paginator;
    })
  }

  ngOnInit(): void {
  }

}
