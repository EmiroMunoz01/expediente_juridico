import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcuradorListadoComponent } from './procurador-listado.component';

describe('ProcuradorListadoComponent', () => {
  let component: ProcuradorListadoComponent;
  let fixture: ComponentFixture<ProcuradorListadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProcuradorListadoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProcuradorListadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
