import { Component, OnInit, Input } from '@angular/core';
import { Kapcsolattarto } from '../kapcsolattarto';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { KapcsolattartoService } from '../kapcsolattarto.service';

@Component({
  selector: 'app-kapcsolattarto-detail',
  templateUrl: './kapcsolattarto-detail.component.html',
  styleUrls: ['./kapcsolattarto-detail.component.css']
})
export class KapcsolattartoDetailComponent implements OnInit {

  @Input() kapcsolattarto?: Kapcsolattarto;

  constructor(
    private route: ActivatedRoute,
    private kapcsolattartoService: KapcsolattartoService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getKapcsolattarto();
  }

  getKapcsolattarto(): void{
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.kapcsolattartoService.getKapcsolattarto(id)
      .subscribe(kapcsolattarto => this.kapcsolattarto = kapcsolattarto);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    if (this.kapcsolattarto) {
      this.kapcsolattartoService.updateKapcsolattarto(this.kapcsolattarto)
        .subscribe(() => this.goBack());
    }
  }

}
