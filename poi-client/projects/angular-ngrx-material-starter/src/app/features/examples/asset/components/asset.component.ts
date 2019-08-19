import { Component, OnInit, ChangeDetectionStrategy, NgZone, ChangeDetectorRef } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormGroupDirective,
  Validators
} from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith, tap } from 'rxjs/operators';

import { ROUTE_ANIMATIONS_ELEMENTS } from '../../../../core/animations/route.animations';
import { Asset, AssetService } from '../../../../core/poi-api';



@Component({
  selector: 'anms-asset',
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})


export class AssetComponent implements OnInit {
  routeAnimationsElements = ROUTE_ANIMATIONS_ELEMENTS;
  form: FormGroup;
  assets: Asset[];
  isEdit$: Observable<{ value: boolean }>;

  constructor(private fb: FormBuilder,
    private service: AssetService,
    private zone: NgZone,
    private cdr: ChangeDetectorRef) { }

  ngOnInit() {
    this.load();
    this.form = this.fb.group({
      id: '',
      key: ['', [Validators.required, Validators.minLength(5)]]
    });

    this.isEdit$ = this.form.get('id').valueChanges.pipe(
      startWith(''),
      map(id => ({ value: (id || '').length > 0 }))
    );
  }

  load() {
    console.log('Loading');
    this.service.findAllAssets().subscribe(res => {
        this.assets = res;
        this.cdr.detectChanges();
    })
  }

  remove(asset: Asset) {
    this.service.deleteAsset(asset.id).subscribe(Res => {
      this.load();
    });
  }

  edit(asset: Asset) {
    this.form.patchValue({ ...asset });
  }

  onSubmit(formRef: FormGroupDirective) {
    const context = this;
    console.log('OnSubmit')
    if (this.form.valid) {
      const data = this.form.getRawValue();
      console.log(data)
      if (data.id) {
        console.log('UPDATE')
        this.service.updateAsset(data).subscribe(Res => {
          this.load();
        });
      } else {
        console.log('ADD')
        this.service.addAsset(data).subscribe(Res => {
          this.load();
        });
      }
      formRef.resetForm();
      this.form.reset();
      this.load();
    }
  }

  trackByUserId(index: number, asset: Asset): number {
    return asset.id;
  }
}
