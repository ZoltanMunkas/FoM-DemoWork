import { Component, OnInit } from '@angular/core';
import { Kapcsolattarto } from '../kapcsolattarto';
import { KapcsolattartoService } from '../kapcsolattarto.service'; 
import { MessageService } from '../message.service';

@Component({
  selector: 'app-kapcsolattarto',
  templateUrl: './kapcsolattarto.component.html',
  styleUrls: ['./kapcsolattarto.component.css']
})
export class KapcsolattartoComponent implements OnInit {

  kapcsolattartok: Kapcsolattarto[] = [];

  getKapcsolattartok(): void {
    this.kapcsolattartoService.getKapcsolattartok()
      .subscribe(kapcsolattartok => this.kapcsolattartok = kapcsolattartok);
  }

  add(firstName: string): void {
    firstName = firstName.trim();
    if (!firstName) { return; }
    this.kapcsolattartoService.addKapcsolattarto({ firstName } as Kapcsolattarto)
      .subscribe(kapcsolattarto => {
        this.kapcsolattartok.push(kapcsolattarto);
      });
  }

  delete(kapcsolattarto: Kapcsolattarto): void {
    this.kapcsolattartok = this.kapcsolattartok.filter(it => it !== kapcsolattarto);
    this.kapcsolattartoService.deleteKapcsolattarto(kapcsolattarto.id).subscribe();
  }

  constructor(private kapcsolattartoService: KapcsolattartoService,
              private messageService: MessageService) { }

  ngOnInit(): void {
    this.getKapcsolattartok();
  }

}