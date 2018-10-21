import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <div style="text-align:center">
      <h1>
        Welcome to Convertor App!
      </h1>
    </div>
    <h2>Here are some links for Metric/Imperial Conversions: </h2>
    <ul>
      <li>
        <h2><a href="/distance">Distance</a></h2>
      </li>
      <li>
        <h2><a href="/temperature">Temperature</a></h2>
      </li>
      <li>
        <h2><a href="/weight">Weight</a></h2>
      </li>
    </ul>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'web';
}
