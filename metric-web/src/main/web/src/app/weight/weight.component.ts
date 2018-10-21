import { Component, OnInit } from '@angular/core';

import { WeightService } from '../weight.service';

import { Measure } from '../measure.model';

@Component({
  selector: 'app-weight',
  templateUrl: './weight.component.html',
  styleUrls: ['./weight.component.css']
})
export class WeightComponent implements OnInit {

  weight : Measure;

  constructor(private weightService : WeightService) { }

  ngOnInit() {
    this.weightService.get().subscribe(data => {
      this.weight = data;
      console.log(new Date() + ": weight = " + JSON.stringify(this.weight));
    }, error => console.error(error));
  }

  convert() {
    this.weightService.convert(this.weight).subscribe(data => {
      this.weight = data;
      console.log(new Date() + ": weight = " + JSON.stringify(this.weight));
    }, error => console.error(error));
  }
}
