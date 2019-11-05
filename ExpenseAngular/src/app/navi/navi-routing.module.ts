import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent } from '../add/add.component';
import { SearchComponent } from '../search/search.component';
import { CommonModule } from '@angular/common';
import { ListComponent } from '../list/list.component';
import { ModifyComponent } from '../modify/modify.component';
import { DeleteComponent } from '../delete/delete.component';

const routes: Routes = [
  { path: "", redirectTo: "/add", pathMatch: "full" },
  { path: "add", component: AddComponent },
  { path: "search", component: SearchComponent },
  { path: "**", redirectTo: "/add", pathMatch: "full" },
  { path: "list", component: ListComponent },
  { path: "modify", component:  ModifyComponent },
  { path: "delete", component: DeleteComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  CommonModule],
  declarations:[],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
