import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomeComponent} from './pages/home/home.component';
import {PointTableComponent} from './pages/point-table/point-table.component';
import {AddMatchComponent} from './pages/add-match/add-match.component';
import {MatchListComponent} from './pages/match-list/match-list.component';
import {ManagerLayoutComponent} from './layouts/manager-layout/manager-layout.component';
import {NavBarComponent} from './layouts/components/nav-bar/nav-bar.component';
import {TableComponent} from './layouts/components/table/table.component';
import {FooterComponent} from './layouts/components/footer/footer.component';
import {PremierLeagueManagerRoutes} from './premier-league-manager-routes';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';

@NgModule({

  declarations: [
    HomeComponent,
    PointTableComponent,
    AddMatchComponent,
    MatchListComponent,
    ManagerLayoutComponent,
    NavBarComponent,
    TableComponent,
    FooterComponent],
  imports: [
    CommonModule,
    PremierLeagueManagerRoutes,
    MatToolbarModule,
    MatButtonModule,
  ]
})
export class PremierLeagueManagerModule {
}
