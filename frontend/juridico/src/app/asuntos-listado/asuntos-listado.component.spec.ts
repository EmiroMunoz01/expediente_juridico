import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsuntosListadoComponent } from './asuntos-listado.component';

describe('AsuntosListadoComponent', () => {
  let component: AsuntosListadoComponent;
  let fixture: ComponentFixture<AsuntosListadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AsuntosListadoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AsuntosListadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
