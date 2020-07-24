import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminDetailComponent } from './admin-detail/admin-detail.component';

const routes: Routes = [
  { path: '', children :[
    { path : 'adminDetail/:id', component : AdminDetailComponent },
    { path : 'adminHome', component : AdminHomeComponent },
    { path : 'admin', component : AdminComponent },
    { path : '', redirectTo : 'admin', pathMatch : 'full' }
  ] }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports : [RouterModule]
})
export class AdministrationRoutingModule { }
