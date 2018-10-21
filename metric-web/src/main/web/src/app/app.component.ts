import { Component, OnInit } from '@angular/core';

import { MeasureService } from './measure.service';

import { Measure } from './measure.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  distance : Measure;
  weight : Measure;
  temperature : Measure;

  constructor(private measureService : MeasureService ) { }

  ngOnInit() {
    this.measureService.get("distance").subscribe(data => {
      this.distance = data;
      console.log(new Date() + ": distance = " + JSON.stringify(this.distance));
    }, error => console.error(error));

    this.measureService.get("weight").subscribe(data => {
      this.weight = data;
      console.log(new Date() + ": weight = " + JSON.stringify(this.weight));
    }, error => console.error(error));

    this.measureService.get("temperature").subscribe(data => {
      this.temperature = data;
      console.log(new Date() + ": temperature = " + JSON.stringify(this.temperature));
    }, error => console.error(error));
  }

  convertDistance() {
    this.measureService.convert("distance", this.distance).subscribe(data => {
      this.distance = data;
      console.log(new Date() + ": distance = " + JSON.stringify(this.distance));
    }, error => console.error(error));
  }

  convertWeight() {
    this.measureService.convert("weight", this.weight).subscribe(data => {
      this.weight = data;
      console.log(new Date() + ": weight = " + JSON.stringify(this.weight));
    }, error => console.error(error));
  }

  convertTemperature() {
    this.measureService.convert("temperature", this.temperature).subscribe(data => {
      this.temperature = data;
      console.log(new Date() + ": temperature = " + JSON.stringify(this.temperature));
    }, error => console.error(error));
  }
}
