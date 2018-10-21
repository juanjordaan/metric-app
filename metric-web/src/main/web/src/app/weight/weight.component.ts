import { Component, OnInit } from '@angular/core';

import { MeasureService } from '../measure.service';

import { Measure } from '../measure.model';

@Component({
  selector: 'app-weight',
  templateUrl: './weight.component.html',
  styleUrls: ['./weight.component.css']
})
export class WeightComponent implements OnInit {

  weight : Measure;

  constructor(private weightService : MeasureService) { }

  ngOnInit() {
    this.weightService.get("weight").subscribe(data => {
      this.weight = data;
      console.log(new Date() + ": weight = " + JSON.stringify(this.weight));
    }, error => console.error(error));
  }

  convert() {
    this.weightService.convert("weight", this.weight).subscribe(data => {
      this.weight = data;
      console.log(new Date() + ": weight = " + JSON.stringify(this.weight));
    }, error => console.error(error));
  }
}
