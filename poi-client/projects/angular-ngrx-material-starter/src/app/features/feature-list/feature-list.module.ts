import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../../shared/shared.module';

import { FeatureListComponent } from './feature-list/feature-list.component';
import { FeatureListRoutingModule } from './feature-list-routing.module';
import { AssetService } from '../../core/poi-api';
import { MatTableModule, MatGridListModule } from '@angular/material';
import { MinuteSecondsPipe } from './feature-list/secounds-pipe';

@NgModule({
  declarations: [FeatureListComponent, MinuteSecondsPipe],
  imports: [CommonModule, SharedModule, FeatureListRoutingModule, MatTableModule, MatGridListModule],
  providers: [AssetService]
})
export class FeatureListModule {}
