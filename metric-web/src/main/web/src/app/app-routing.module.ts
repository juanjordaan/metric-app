import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DistanceComponent } from './distance/distance.component';
import { TemperatureComponent } from './temperature/temperature.component';
import { WeightComponent } from './weight/weight.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'distance',
    component: DistanceComponent
  },
  {
    path: 'temperature',
    component: TemperatureComponent
  },
  {
    path: 'weight',
    component: WeightComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
