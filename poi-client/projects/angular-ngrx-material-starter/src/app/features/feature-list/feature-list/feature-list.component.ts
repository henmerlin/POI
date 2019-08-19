import { Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef, Pipe, PipeTransform } from '@angular/core';

import { ROUTE_ANIMATIONS_ELEMENTS } from '../../../core/core.module';

import { Asset, AssetService } from '../../../core/poi-api';
import { trigger, state, transition, style, animate } from '@angular/animations';
import { FormControl } from '@angular/forms';

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
  assets: Asset[];
  searchKey = new FormControl();
  initialDate = new FormControl(new Date(0));
  finalDate  = new FormControl(new Date());
  columnsToDisplay = ['key'];
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
   // const filter;
    this.service.getAssetByFilter(this.searchKey.value, this.initialDate.value.getTime(), this.finalDate.value.getTime()).subscribe(res => {
      this.assets = res;
      this.cdr.detectChanges();
    })
  }

}

