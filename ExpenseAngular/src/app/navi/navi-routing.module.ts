import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent } from '../add/add.component';
import { SearchComponent } from '../search/search.component';
import { ListComponent } from '../list/list.component';
import { ModifyComponent } from '../modify/modify.component';
import { DeleteComponent } from '../delete/delete.component';
import { CommonModule } from '@angular/common';
import { LoginComponent } from '../login/login.component';
import { LogoutComponent } from '../logout/logout.component';

const routes: Routes = [
  { path: "", redirectTo: "/login", pathMatch: "full" },
  { path: "login", component: LoginComponent },
  { path: "logout", component: LogoutComponent },
  { path: "add", component: AddComponent },
  { path: "search", component: SearchComponent },
  { path: "list", component: ListComponent },
  { path: "modify", component: ModifyComponent },
  { path: "delete", component: DeleteComponent },
  { path: "**", redirectTo: "/add", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    CommonModule],
  declarations: [],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
