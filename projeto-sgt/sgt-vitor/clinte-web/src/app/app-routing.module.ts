import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from './views/home/home.component';
import {TarefasComponent} from "./views/tarefas/tarefas.component";
import {ResponsvelComponent} from './views/responsvel/responsvel.component'
import {TarefasCreateComponent} from "./components/tarefas/tarefas-create/tarefas-create.component";
import {ResponsavelCreateComponent} from "./components/responsavel/responsavel-create/responsavel-create.component";
import {TarefasUpdateComponent} from "./components/tarefas/tarefas-update/tarefas-update.component";
import {TarefasDeleteComponent} from "./components/tarefas/tarefas-delete/tarefas-delete.component";
import {ResponsavelUpdateComponent} from "./components/responsavel/responsavel-update/responsavel-update.component";

const routes: Routes = [{
  path:"",
  component:HomeComponent
},
  {
    path:"Tarefa",
    component: TarefasComponent
  },
  {
    path:"Responsavel",
    component:ResponsvelComponent
  },
  {
    path:"tarefas/create",
    component:TarefasCreateComponent
  },
  {
    path:"tarefas/update/:id",
    component:TarefasUpdateComponent
  },
  {
    path:"tarefas/delete/:id",
    component:TarefasDeleteComponent
  },

  {
    path: "responsavel/create",
    component:ResponsavelCreateComponent
  },
  {
    path: "responsavel/update/:id",
    component:ResponsavelUpdateComponent
  },
  {
    path: "responsavel/delete/:id",
    component:ResponsavelUpdateComponent
  }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
