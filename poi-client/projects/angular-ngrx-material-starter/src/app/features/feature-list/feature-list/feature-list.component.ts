import { filter } from 'rxjs/operators';
import { Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';

import { ROUTE_ANIMATIONS_ELEMENTS } from '../../../core/core.module';

import { Feature, features } from '../feature-list.data';
import { Asset, AssetService } from '../../../core/poi-api';
import { trigger, state, transition, style, animate } from '@angular/animations';

@Component({
  selector: 'anms-feature-list',
  templateUrl: './feature-list.component.html',
  styleUrls: ['./feature-list.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ])]
})
export class FeatureListComponent implements OnInit {
  routeAnimationsElements = ROUTE_ANIMATIONS_ELEMENTS;
  features: Feature[] = features;
  assets: Asset[];
  columnsToDisplay = ['name', 'weight', 'symbol', 'position'];
  expandedElement: Asset | null;

  constructor(
    private service: AssetService,
    private cdr: ChangeDetectorRef) { }

  ngOnInit() {
    this.load();
  }

  openLink(link: string) {
    window.open(link, '_blank');
  }

  load() {
    console.log('Loading');
    this.service.getAssetByFilter().subscribe(res => {
      this.assets = res;
      this.cdr.detectChanges();
    })
  }

}
