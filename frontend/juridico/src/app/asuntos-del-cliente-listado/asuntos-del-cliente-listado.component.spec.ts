import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsuntosDelClienteListadoComponent } from './asuntos-del-cliente-listado.component';

describe('AsuntosDelClienteListadoComponent', () => {
  let component: AsuntosDelClienteListadoComponent;
  let fixture: ComponentFixture<AsuntosDelClienteListadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AsuntosDelClienteListadoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AsuntosDelClienteListadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
