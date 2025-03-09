import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcuradorFormularioComponent } from './procurador-formulario.component';

describe('ProcuradorFormularioComponent', () => {
  let component: ProcuradorFormularioComponent;
  let fixture: ComponentFixture<ProcuradorFormularioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProcuradorFormularioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProcuradorFormularioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
