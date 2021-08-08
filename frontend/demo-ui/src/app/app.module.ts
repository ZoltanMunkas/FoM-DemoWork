import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { KapcsolattartoComponent } from './kapcsolattarto/kapcsolattarto.component';
import { KapcsolattartoDetailComponent } from './kapcsolattarto-detail/kapcsolattarto-detail.component';
import { MessagesComponent } from './messages/messages.component';

@NgModule({
  declarations: [
    AppComponent,
    KapcsolattartoComponent,
    KapcsolattartoDetailComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
