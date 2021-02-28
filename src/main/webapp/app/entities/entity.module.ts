import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'person',
        loadChildren: () => import('./person/person.module').then(m => m.AlesiaPersonModule),
      },
      {
        path: 'organization',
        loadChildren: () => import('./organization/organization.module').then(m => m.AlesiaOrganizationModule),
      },
      {
        path: 'location',
        loadChildren: () => import('./location/location.module').then(m => m.AlesiaLocationModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class AlesiaEntityModule {}
