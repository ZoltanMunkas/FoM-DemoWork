import { Component, OnInit, Input } from '@angular/core';
import { Kapcsolattarto } from '../kapcsolattarto';


@Component({
  selector: 'app-kapcsolattarto-detail',
  templateUrl: './kapcsolattarto-detail.component.html',
  styleUrls: ['./kapcsolattarto-detail.component.css']
})
export class KapcsolattartoDetailComponent implements OnInit {

  @Input() kapcsolattarto?: Kapcsolattarto;

  constructor() { }

  ngOnInit(): void {
  }

}
