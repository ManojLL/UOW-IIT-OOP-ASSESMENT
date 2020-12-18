import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ManagerLayoutComponent} from './layouts/manager-layout/manager-layout.component';
import {PointTableComponent} from './pages/point-table/point-table.component';
import {AddMatchComponent} from './pages/add-match/add-match.component';
import {MatchListComponent} from './pages/match-list/match-list.component';
import {HomeComponent} from './pages/home/home.component';


const routes: Routes = [
  {path: '', redirectTo: '/manager/home', pathMatch: 'full'},
  {
    path: '',
    component: ManagerLayoutComponent,
    children: [
      {
        path: 'home',
        component: HomeComponent,
      },
      {
        path: 'point-table',
        component: PointTableComponent,
      },
      {
        path: 'matches',
        component: MatchListComponent,
      },
      {
        path: 'add-match',
        component: AddMatchComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PremierLeagueManagerRoutes {
}
