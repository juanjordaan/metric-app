import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Measure } from './measure.model';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Accept':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class WeightService {

  constructor(private http: HttpClient) { }

  get(): Observable<any> {
    return this.http.get('//localhost:8080/convert/weight', {headers: httpOptions.headers});
  }

  convert(measure : Measure) : Observable<any> {
    return this.http.post('//localhost:8080/convert/weight',measure , {headers: httpOptions.headers});
  }
}
