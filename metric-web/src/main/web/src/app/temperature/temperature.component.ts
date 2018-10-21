import { Component, OnInit } from '@angular/core';

import { MeasureService } from '../measure.service';

import { Measure } from '../measure.model';

@Component({
  selector: 'app-temperature',
  templateUrl: './temperature.component.html',
  styleUrls: ['./temperature.component.css']
})
export class TemperatureComponent implements OnInit {

  temperature : Measure;

  constructor(private temperatureService : MeasureService) { }

  ngOnInit() {
    this.temperatureService.get("temperature").subscribe(data => {
      this.temperature = data;
      console.log(new Date() + ": temperature = " + JSON.stringify(this.temperature));
    }, error => console.error(error));
  }

  convert() {
    this.temperatureService.convert("temperature", this.temperature).subscribe(data => {
      this.temperature = data;
      console.log(new Date() + ": temperature = " + JSON.stringify(this.temperature));
    }, error => console.error(error));
  }
}
