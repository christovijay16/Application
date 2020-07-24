import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdministrationRoutingModule } from './administration-routing.module';
import { AdminComponent } from './admin/admin.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { FormsModule } from '@angular/forms';
import { AdminDetailComponent } from './admin-detail/admin-detail.component';

@NgModule({
  declarations: [AdminComponent, AdminHomeComponent, AdminDetailComponent],
  imports: [
    CommonModule,
    FormsModule,
    AdministrationRoutingModule
  ]
})
export class AdministrationModule { }
