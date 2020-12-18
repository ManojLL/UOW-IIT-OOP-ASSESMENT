import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LeagueComponent} from './league.component';
import {PremierLeagueRouterModule} from './premier-league-router.module';
import {NavbarComponent} from './layouts/components/navbar/navbar.component';
import {FooterComponent} from './layouts/components/footer/footer.component';
import {HeroImageComponent} from './layouts/components/hero-image/hero-image.component';
import {ManagerLayoutComponent} from './layouts/manager-layout/manager-layout.component';
import {HomePageComponent} from './pages/home-page/home-page.component';
import {MatchCardComponent} from './layouts/components/match-card/match-card.component';
import {PointTableComponent} from './pages/point-table/point-table.component';
import {TableComponent} from './layouts/components/table/table.component';
import {MatchesComponent} from './pages/matches/matches.component';
import {PageComponent} from './pages/matches/component/page/page.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTableModule} from '@angular/material/table';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {HttpClientModule} from '@angular/common/http';
import {MatTabsModule} from '@angular/material/tabs';
import {MatPaginatorModule} from '@angular/material/paginator';
import {NgxPaginationModule} from 'ngx-pagination';
import {MatInputModule} from '@angular/material/input';
import {SearchMatchComponent} from './pages/matches/component/search-match/search-match.component';
import {FormsModule} from '@angular/forms';
import {AltertsComponent} from './pages/matches/component/search-match/component/alterts/alterts.component';
import {MatDialogModule} from '@angular/material/dialog';
import {AddMatchComponent} from './pages/add-match/add-match.component';

@NgModule({
  declarations: [
    ManagerLayoutComponent,
    LeagueComponent,
    NavbarComponent,
    FooterComponent,
    HeroImageComponent,
    HomePageComponent,
    MatchCardComponent,
    PointTableComponent,
    TableComponent,
    MatchesComponent,
    PageComponent,
    SearchMatchComponent,
    AltertsComponent,
    AddMatchComponent,
  ],
  imports: [
    CommonModule,
    PremierLeagueRouterModule,
    MatToolbarModule,
    MatTableModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    HttpClientModule,
    MatTabsModule,
    MatPaginatorModule,
    NgxPaginationModule,
    MatInputModule,
    FormsModule,
    MatDialogModule,
  ]
})
export class PremierLEagueManagerModule {
}
