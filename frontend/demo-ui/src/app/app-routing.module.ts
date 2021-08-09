import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { KapcsolattartoComponent } from './kapcsolattarto/kapcsolattarto.component'; 
import { DashboardComponent } from './dashboard/dashboard.component';
import { KapcsolattartoDetailComponent } from './kapcsolattarto-detail/kapcsolattarto-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'detail/:id', component: KapcsolattartoDetailComponent },
  { path: 'kapcsolattartok', component: KapcsolattartoComponent },
  { path: 'dashboard', component: DashboardComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }