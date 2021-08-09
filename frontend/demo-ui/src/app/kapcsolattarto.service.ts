import { Injectable } from '@angular/core';
import { Kapcsolattarto } from './kapcsolattarto'; 
import { KAPCSOLATTARTOK } from './dummy-data';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class KapcsolattartoService {

  private kapcsolattartoUrl = 'http://localhost:8080/kapcsolattartok';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }

  getKapcsolattartok(): Observable<Kapcsolattarto[]> {
    return this.http.get<Kapcsolattarto[]>(this.kapcsolattartoUrl)
      .pipe(
        tap(_ => this.log('kapcsolattartok lekerve')),
        catchError(this.handleError<Kapcsolattarto[]>('getKapcsolattartok', []))
      );
  }

  getKapcsolattarto(id: number): Observable<Kapcsolattarto> {
    const url = `${this.kapcsolattartoUrl}/${id}`;
    return this.http.get<Kapcsolattarto>(url).pipe(
      tap(_ => this.log(`kapcsolattarto ${id} lekerve`)),
      catchError(this.handleError<Kapcsolattarto>(`getKapcsolattartok id=${id}`))
    );
  }

  updateKapcsolattarto(kapcsolattarto: Kapcsolattarto): Observable<any> {
    return this.http.put(this.kapcsolattartoUrl, kapcsolattarto, this.httpOptions).pipe(
      tap(_ => this.log(`updated id=${kapcsolattarto.id}`)),
      catchError(this.handleError<any>('updateKapcsolattarto'))
    );
  }

  private log(message: string) {
    this.messageService.add(`KapcsolattartoService: ${message}`);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

}
