import { Component, OnInit } from '@angular/core';

import { MeasureService } from '../measure.service';

import { Measure } from '../measure.model';

@Component({
  selector: 'app-distance',
  templateUrl: './distance.component.html',
  styleUrls: ['./distance.component.css']
})
export class DistanceComponent implements OnInit {

  distance : Measure;

  constructor(private distanceService : MeasureService ) { }

  ngOnInit() {
    this.distanceService.get("distance").subscribe(data => {
      this.distance = data;
      console.log(new Date() + ": distance = " + JSON.stringify(this.distance));
    }, error => console.error(error));
  }

  convert() {
    this.distanceService.convert("distance", this.distance).subscribe(data => {
      this.distance = data;
      console.log(new Date() + ": distance = " + JSON.stringify(this.distance));
    }, error => console.error(error));
  }
}
