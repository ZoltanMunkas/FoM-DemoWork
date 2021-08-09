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

  constructor(private kapcsolattartoService: KapcsolattartoService,
              private messageService: MessageService) { }

  ngOnInit(): void {
    this.getKapcsolattartok();
  }

}