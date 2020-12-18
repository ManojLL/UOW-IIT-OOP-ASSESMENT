import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: '/manager/home', pathMatch: 'full'},
  {
    path: 'manager',
    loadChildren: () =>
      import('./modules/premier-league-manager/premier-league-manager.module').then(
        manager => manager.PremierLeagueManagerModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
