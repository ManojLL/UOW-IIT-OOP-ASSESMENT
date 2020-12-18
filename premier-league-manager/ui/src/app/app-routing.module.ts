import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: '/premierLeague-manager/home', pathMatch: 'full'},
  {
    path: 'premierLeague-manager',
    loadChildren: () => import('./modules/premier-league-manager/premier-league-manager.module').then(l =>
      l.PremierLEagueManagerModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
