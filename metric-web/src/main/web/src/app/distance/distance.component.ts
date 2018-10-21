import { Component, OnInit } from '@angular/core';

import { DistanceService } from '../distance.service';

import { Measure } from '../measure.model';

@Component({
  selector: 'app-distance',
  templateUrl: './distance.component.html',
  styleUrls: ['./distance.component.css']
})
export class DistanceComponent implements OnInit {

  distance : Measure;

  constructor(private distanceService : DistanceService ) { }

  ngOnInit() {
    this.distanceService.get().subscribe(data => {
      this.distance = data;
      console.log(new Date() + ": distance = " + JSON.stringify(this.distance));
    }, error => console.error(error));
  }

  convert() {
    this.distanceService.convert(this.distance).subscribe(data => {
      this.distance = data;
      console.log(new Date() + ": distance = " + JSON.stringify(this.distance));
    }, error => console.error(error));
  }
}
