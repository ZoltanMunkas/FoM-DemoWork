import { Injectable } from '@angular/core';
import { Kapcsolattarto } from './kapcsolattarto'; 
import { KAPCSOLATTARTOK } from './dummy-data';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class KapcsolattartoService {

  constructor(private messageService: MessageService) { }

  getKapcsolattartok(): Observable<Kapcsolattarto[]> {
    const kapcsolattartok = of(KAPCSOLATTARTOK);
    this.messageService.add('Kapcsolattartók lekérve');
    return kapcsolattartok;
  }

}
