import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomePageComponent} from './pages/home-page/home-page.component';
import {ManagerLayoutComponent} from './layouts/manager-layout/manager-layout.component';
import {MatchesComponent} from './pages/matches/matches.component';
import {PointTableComponent} from './pages/point-table/point-table.component';
import {AddMatchComponent} from './pages/add-match/add-match.component';

const routes: Routes = [
  {path: '', redirectTo: '/premierLeague-manager/home', pathMatch: 'full'},
  {
    path: '',
    component: ManagerLayoutComponent,
    children: [
      {
        path: 'home',
        component: HomePageComponent,
      },
      {
        path: 'point-table',
        component: PointTableComponent,
      },
      {
        path: 'matches',
        component: MatchesComponent,
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
export class PremierLeagueRouterModule {
}
