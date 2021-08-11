import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from './views/home/home.component';
import {TarefasComponent} from "./views/tarefas/tarefas.component";
import {ResponsvelComponent} from './views/responsvel/responsvel.component'
import {TarefasCreateComponent} from "./components/tarefas/tarefas-create/tarefas-create.component";
import {ResponsavelCreateComponent} from "./components/responsavel/responsavel-create/responsavel-create.component";

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
    path: "responsavel/create",
    component:ResponsavelCreateComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
