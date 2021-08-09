import { Component, OnInit } from '@angular/core';
import { Kapcsolattarto } from '../kapcsolattarto';
import { KapcsolattartoService } from '../kapcsolattarto.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  kapcsolattartok: Kapcsolattarto[] = [];

  constructor(private kapcsolattartoService: KapcsolattartoService) { }

  ngOnInit(): void {
    this.getKapcsolattartok();
  }

  getKapcsolattartok(): void{
    this.kapcsolattartoService.getKapcsolattartok()
    .subscribe(kapcsolattartok => this.kapcsolattartok = kapcsolattartok.slice(1, 5));
  }

}
