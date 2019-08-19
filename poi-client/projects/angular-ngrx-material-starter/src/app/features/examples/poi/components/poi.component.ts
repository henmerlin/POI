import { Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormGroupDirective,
  Validators
} from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith} from 'rxjs/operators';

import { ROUTE_ANIMATIONS_ELEMENTS } from '../../../../core/animations/route.animations';
import { PoiService, Poi } from '../../../../core/poi-api';


@Component({
  selector: 'anms-poi',
  templateUrl: './poi.component.html',
  styleUrls: ['./poi.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})


export class PoiComponent implements OnInit {
  routeAnimationsElements = ROUTE_ANIMATIONS_ELEMENTS;
  form: FormGroup;
  pois: Poi[];
  isEdit$: Observable<{ value: boolean }>;

  constructor(private fb: FormBuilder,
    private service: PoiService,
    private cdr: ChangeDetectorRef) { }

  ngOnInit() {
    this.load();
    this.form = this.fb.group({
      id: '',
      name: ['', [Validators.required, Validators.minLength(5)]],
      radiusMeters: ['', [Validators.required, Validators.minLength(5)]]
    });

    this.isEdit$ = this.form.get('id').valueChanges.pipe(
      startWith(''),
      map(id => ({ value: (id || '').length > 0 }))
    );
  }

  load() {
    console.log('Loading');
    this.service.findAllPois().subscribe(res => {
        this.pois = res;
        this.cdr.detectChanges();
    })
  }

  formatLabel(value: number | null) {
    if (!value) {
      return 0;
    }
    return value + 'm';
  }

  remove(poi: Poi) {
    this.service.deletePoi(poi.id).subscribe(Res => {
      this.load();
    });
  }

  edit(poi: Poi) {
    this.form.patchValue({ ...poi });
  }

  onSubmit(formRef: FormGroupDirective) {
    const context = this;
    console.log('OnSubmit')
    if (this.form.valid) {
      const data = this.form.getRawValue();
      console.log(data)
      if (data.id) {
        console.log('UPDATE')
        this.service.updatePoi(data).subscribe(Res => {
          this.load();
        });
      } else {
        console.log('ADD')
        this.service.addPoi(data).subscribe(Res => {
          this.load();
        });
      }
      formRef.resetForm();
      this.form.reset();
      this.load();
    }
  }

  trackByUserId(index: number, poi: Poi): number {
    return poi.id;
  }
}
