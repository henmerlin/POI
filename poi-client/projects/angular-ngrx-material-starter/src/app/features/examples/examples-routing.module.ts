import { AssetComponent } from './asset/components/asset.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthGuardService } from '../../core/core.module';

import { ExamplesComponent } from './examples/examples.component';
import { ParentComponent } from './theming/parent/parent.component';
import { AuthenticatedComponent } from './authenticated/authenticated.component';
import { TodosContainerComponent } from './todos/components/todos-container.component';
import { StockMarketContainerComponent } from './stock-market/components/stock-market-container.component';
import { CrudComponent } from './crud/components/crud.component';
import { FormComponent } from './form/components/form.component';
import { NotificationsComponent } from './notifications/components/notifications.component';
import { UserComponent } from './simple-state-management/components/user.component';
import { ElementsComponent } from './elements/elements.component';
import { PoiComponent } from './poi/components/poi.component';
import { BASE_PATH } from '../../core/poi-api';
import { environment } from '../../../environments/environment.prod';

const routes: Routes = [
  {
    path: '',
    component: ExamplesComponent,
    children: [
      {
        path: 'asset',
        redirectTo: 'asset/',
        pathMatch: 'full'
      },
      {
        path: 'asset/:id',
        component: AssetComponent,
        data: { title: 'anms.examples.menu.asset' }
      },
      {
        path: 'poi',
        redirectTo: 'poi/',
        pathMatch: 'full'
      },
      {
        path: 'poi/:id',
        component: PoiComponent,
        data: { title: 'anms.examples.men  u.poi' }
      },
      {
        path: 'notifications',
        component: NotificationsComponent,
        data: { title: 'anms.examples.menu.notifications' }
      },
      {
        path: 'elements',
        component: ElementsComponent,
        data: { title: 'anms.examples.menu.elements' }
      },
      {
        path: 'authenticated',
        component: AuthenticatedComponent,
        canActivate: [AuthGuardService],
        data: { title: 'anms.examples.menu.auth' }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [{ provide: BASE_PATH, useValue: environment.API_BASE_PATH }]
})
export class ExamplesRoutingModule {}
